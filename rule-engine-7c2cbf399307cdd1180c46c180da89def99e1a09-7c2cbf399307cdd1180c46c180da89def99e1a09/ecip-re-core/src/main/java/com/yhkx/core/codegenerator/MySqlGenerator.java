package com.yhkx.core.codegenerator;

import com.yhkx.core.codegenerator.core.DataProcessor;
import com.yhkx.core.codegenerator.core.VelocityConfiguration;
import com.yhkx.core.codegenerator.model.Table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


/**
 * 从数据库表结构生成myBaits相关类的工具
 *
 * @author LiSs
 * @date on 2018/7/04
 */
public class MySqlGenerator {
    private static String url = "jdbc:mysql://localhost:3306/yhkx";
    private static String driver = "com.mysql.jdbc.Driver";
    private static String user = "root";
    private static String password = "password";

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection;
        Class.forName(driver);
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public static String getProjectPath() throws Exception {
        java.net.URL url = MySqlGenerator.class.getProtectionDomain().getCodeSource().getLocation();
        String filePath = java.net.URLDecoder.decode(url.getPath(), "utf-8");
        //TODO:MAC和WIN有差别，substring的startIndex分别为0和1
        filePath = filePath.substring(0, filePath.length() - ("/target/classes/").length());
        return filePath;
    }

    public static void main(String[] args) throws Exception {
        //需要生成DB类的表名、支持正则匹配、推荐使用精确匹配、一张一张地生成
        String wantedTableName = "worker";

        VelocityConfiguration config = new VelocityConfiguration();
        config.setTargetDir(getProjectPath() + "/src/main/java/");
        config.setModelPackage("com.yhkx.core.storage.dao.entity");
        config.setMapperPackage("com.yhkx.core.storage.dao.mapper");
        config.setXmlPackage("mapper");

        Generator generator = new Generator(config);
        Connection connection = getConnection();
        DataProcessor t = new DataProcessor(connection);

        List<Table> tableInfos = t.getTableInfoList(wantedTableName);
        connection.close();

        try {
            String xmlDir = config.getTargetDir().replace("java/", "resources/");
            for (Table table : tableInfos) {
                //生成数据Model映射
                generator.generateModel(config.getTargetDir(), table);
                //生成数据操作Mapper
                generator.generateMapper(config.getTargetDir(), table);
                generator.generateXml(xmlDir, table);
            }
        } catch (Exception e) {
        }
    }

}
