//package com.webproject.db;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class JdbcConnection {
//
//    private final static String DB_DRIVER_CLASS = "org.h2.Driver";
//
//
//    private Connection con = null;
//
//    public JdbcConnection(String dbURL, String dbUser, String dbPassword) {
//
//        try {
//            Class.forName(DB_DRIVER_CLASS);
//            this.con = DriverManager.getConnection(dbURL, dbUser, dbPassword);
//            System.out.println("DB Connection created successfully");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Can't get driver: " + e.getMessage());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Connection getConnection() {
//        return this.con;
//    }
//
//    public void closeConnection() throws SQLException {
//        con.close();
//    }
//}
