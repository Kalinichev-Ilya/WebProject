package com.webproject.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
//TODO Добавить пул коннектов;
    private final static String DB_DRIVER_CLASS = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:file:C:\\java\\IdeaProjects\\epam\\WebProject\\src\\main\\resources";
    private final static String DB_USERNAME = "sa";
    private final static String DB_PASSWORD = "";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        try {
            Class.forName(DB_DRIVER_CLASS);
            con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("DB Connection created successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't get driver: " + e.getMessage());
        }
        return con;
    }
}
