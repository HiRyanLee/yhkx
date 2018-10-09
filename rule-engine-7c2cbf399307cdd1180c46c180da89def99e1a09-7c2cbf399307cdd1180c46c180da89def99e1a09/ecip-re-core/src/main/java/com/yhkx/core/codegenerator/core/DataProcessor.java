package com.yhkx.core.codegenerator.core;

import com.yhkx.core.codegenerator.model.Column;
import com.yhkx.core.codegenerator.model.Table;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 数据表的预处理
 *
 * @author LiSs
 * @date on 2018/7/04
 */
public class DataProcessor {

    private Connection connection;

    public DataProcessor(Connection con) {
        connection = con;
    }

    /**
     * 根据正则表达式匹配表名，获取到表的基本信息
     *
     * @param tableNamePattern
     * @return
     */
    public List<Table> getTableInfoList(String tableNamePattern) {
        Map<String, Map<String, Map<String, Object>>> oracleTableInfoMap = getOracleTableInfoMap(tableNamePattern);
        List<Table> tableInfoList = oracleTableInfoMap2TableInfoList(oracleTableInfoMap);
        prepareProcessTableInfos(tableInfoList);
        return tableInfoList;
    }

    /**
     * 从Oracle中获取所有的表结构信息
     *
     * @param tableNamePattern
     * @return <tableName, <columnName, <column_property_name,column_property_value>>>
     */
    private Map<String, Map<String, Map<String, Object>>> getOracleTableInfoMap(String tableNamePattern) {
        Map<String, Map<String, Map<String, Object>>> tableInfoMap = new HashMap<>();

        try {
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet rs = meta.getColumns(null, null, tableNamePattern, null);

            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                String columnName = rs.getString("COLUMN_NAME");
                String jdbcType = rs.getString("TYPE_NAME");
                if (jdbcType.equals("DATETIME")) {
                    jdbcType = "DATE";
                }
                if (jdbcType.equals("INT")) {
                    jdbcType = "INTEGER";
                }
                if (jdbcType.equals("VARCHAR2")) {
                    jdbcType = "VARCHAR";
                }
                if (jdbcType.equals("NUMBER")) {
                    jdbcType = "DECIMAL";
                }

                Integer dataType = rs.getInt("DATA_TYPE");
                String remarks = rs.getString("REMARKS");
                Map<String, Map<String, Object>> table = tableInfoMap.get(tableName);
                if (table == null) {
                    table = new HashMap<>();
                    tableInfoMap.put(tableName, table);
                }
                Map<String, Object> columnPropertyMap = new HashMap<>();
                columnPropertyMap.put("jdbcType", jdbcType);
                columnPropertyMap.put("remark", remarks);
                columnPropertyMap.put("dataType", dataType);
                columnPropertyMap.put("length", rs.getInt("COLUMN_SIZE"));
                columnPropertyMap.put("isnull", rs.getInt("NULLABLE"));
                table.put(columnName, columnPropertyMap);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        }
        return tableInfoMap;
    }

    /**
     * 将oracle中的tableInfoMap转换成tableList
     *
     * @param oracleTableInfoMap
     * @return TableList中每个Table是一张表的描述
     */
    private List<Table> oracleTableInfoMap2TableInfoList(Map<String, Map<String, Map<String, Object>>> oracleTableInfoMap) {
        List<Table> tableInfoList = new ArrayList<>();

        for (Entry<String, Map<String, Map<String, Object>>> entry : oracleTableInfoMap.entrySet()) {
            Table table = new Table();

            String tableName = entry.getKey();
            table.setTableName(tableName);
            List<Column> columns = new ArrayList<>();
            table.setColumns(columns);

            tableInfoList.add(table);

            Map<String, Map<String, Object>> oracleColumns = entry.getValue();
            for (Entry<String, Map<String, Object>> oracleColumn : oracleColumns.entrySet()) {
                Column column = new Column();
                column.setColumn(oracleColumn.getKey());
                Map<String, Object> columnPropertyMap = oracleColumn.getValue();
                column.setJdbcType((String) columnPropertyMap.get("jdbcType"));
                column.setDataType((int) columnPropertyMap.get("dataType"));
                column.setMaxLength((int) columnPropertyMap.get("length"));
                column.setRemark((String) columnPropertyMap.get("remark"));
                int isnull = (int) columnPropertyMap.get("isnull");
                if (isnull == 0) {
                    column.setAllowNull(false);
                } else {
                    column.setAllowNull(true);
                }
                //将JDBCType转换为JavaType
                String javaType = TypeUtils.getJavaType(column.getDataType());
                column.setJavaType(javaType);
                if ("Date".equals(javaType)) {
                    table.setHasDate(true);
                } else if ("BigDecimal".equals(javaType)) {
                    table.setHasBigdecimal(true);
                }
                columns.add(column);
            }
        }
        return tableInfoList;
    }

    private void prepareProcessTableInfos(List<Table> tableInfoList) {
        try {
            for (Table table : tableInfoList) {
                //设置主键列表
                List<String> primaryKeys = new ArrayList<>();
                ResultSet keysSet = connection.getMetaData().getPrimaryKeys(null, null, table.getTableName());
                while (keysSet.next()) {
                    String primaryKey = keysSet.getString("COLUMN_NAME");
                    primaryKeys.add(primaryKey);
                }
                table.setPrimaryKeys(primaryKeys);
                table.setBeanName(StringUtils.underLineToCamel(StringUtils.firstChar2UpperCase(table.getTableName().toLowerCase())));
                table.setLowerBeanName(table.getBeanName().toLowerCase());
                prepareProcessColumns(table.getColumns());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    private void prepareProcessColumns(List<Column> columnList) {
        for (Column column : columnList) {
            String lowerProperty = StringUtils.underLineToCamel(column.getColumn().toLowerCase());
            column.setLowerProperty(lowerProperty);
            column.setProperty(StringUtils.firstChar2UpperCase(StringUtils.underLineToCamel(lowerProperty)));
        }
    }
}
