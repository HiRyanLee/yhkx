package com.yhkx.core.codegenerator.core;

/**
 * JDBCType到JavaType的转换器
 *
 * @author LiSs
 * @date on 2018/7/04
 */
public class TypeUtils {

    /**
     * DataType转换成JdbcType
     *
     * @param dataType
     * @return
     */
    public static String getJavaType(int dataType) {
        return getJavaType(CommonDataType.getJdbcType(dataType));
    }

    /**
     * JdbcType转换成JavaType
     *
     * @param jdbcType
     * @return
     */
    public static String getJavaType(String jdbcType) {
        String lowerJdbcType = jdbcType.toLowerCase();
        String type = "unknownType";
        if (lowerJdbcType.equals("char") || lowerJdbcType.equals("varchar") || lowerJdbcType.equals("longvarchar")) {
            type = "String";
        }
        if (lowerJdbcType.equals("bit")) {
            type = "Boolean";
        }

        if (lowerJdbcType.equals("tinyint") || lowerJdbcType.equals("smallint")
                || lowerJdbcType.equals("integer")) {
            type = "Integer";
        }

        if (lowerJdbcType.equals("bigint")) {
            type = "Long";
        }

        if (lowerJdbcType.equals("float")) {
            type = "Float";
        }
        if (lowerJdbcType.equals("double")) {
            type = "Double";
        }
        if (lowerJdbcType.equals("numeric") || lowerJdbcType.equals("decimal")) {
            type = "BigDecimal";
        }

        if (lowerJdbcType.equals("date") || lowerJdbcType.equals("time") || lowerJdbcType.equals("timestamp")) {
            type = "Date";
        }
        if (lowerJdbcType.equals("blob") || lowerJdbcType.equals("binary") || lowerJdbcType.equals("varbinary") || lowerJdbcType.equals("longvarbinary")) {
            type = "byte[]";
        }

        return type;
    }
}
