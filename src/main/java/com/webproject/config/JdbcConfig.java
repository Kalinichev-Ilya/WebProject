package com.webproject.config;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.io.*;
import java.util.Properties;

public class JdbcConfig {
    public DataSource dataSource() {
        try (InputStream inputStream = new FileInputStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            BasicDataSource dataSource = new BasicDataSource();

            dataSource.setUsername(properties.getProperty("datasource.username"));
            dataSource.setPassword(properties.getProperty("datasource.password"));
            dataSource.setDriverClassName(properties.getProperty("datasource.driver"));
            dataSource.setUrl(properties.getProperty("datasource.url"));

            return dataSource;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(),e);
        }
    }
}
