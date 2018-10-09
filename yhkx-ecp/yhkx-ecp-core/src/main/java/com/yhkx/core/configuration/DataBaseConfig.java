package com.yhkx.core.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author uniqu
 */
@Configuration
@MapperScan(basePackages = "com.yhkx.core.storage.dao.mapper", sqlSessionTemplateRef = "framedbSqlSessionTemplate")
public class DataBaseConfig {
    public static void main(String[] a)
            throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.
                getConnection("jdbc:h2:file:F:/易好快修/gitspace/yhkx-ecp\\dev", "ROOT", "YHKX");
        // add application code here
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM USER_INFO ");
        //System.out.println(rs.getString("nick_name"));
        while(rs.next()) {
            System.out.println(rs.getString("nick_name"));
        }
        conn.close();
    }
    @Bean(name = "framedbDataSource")
    @ConfigurationProperties(prefix = "framedb.spring.datasource")
    public DataSource framedbDataSource() {
        return new DruidDataSource();
    }


    @Bean(name = "framedbSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("framedbDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "framedbTransactionManager")
    public DataSourceTransactionManager testTransactionManager(
            @Qualifier("framedbDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "framedbSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("framedbSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}