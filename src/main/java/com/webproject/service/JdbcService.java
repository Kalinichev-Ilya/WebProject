package com.webproject.service;

import com.webproject.db.JdbcConnection;
import com.webproject.exceptions.InvalidPasswordException;
import com.webproject.exceptions.SignUpException;

import java.sql.*;

public class JdbcService {
    private String userName;
    private String password;
    public static final String COLUMN_PASSWORD = "password";

    public JdbcService(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Connection getConnection() throws SignUpException {
        Connection con = null;
        try {
            return con = JdbcConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static final String SELECT_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?;";

    public boolean validateDataFromDB(Connection con) {
        try (PreparedStatement statement = con.prepareStatement(SELECT_USER_BY_LOGIN)) {
            statement.setString(1, userName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String passwordFromDB = resultSet.getString(COLUMN_PASSWORD);
                    if (passwordFromDB.equals(password)) {
                        return true;
                    } else
                        throw new InvalidPasswordException("Invalid password!");
                }
            }
        } catch (SQLException e) {
            System.out.println("Can't get connection: " + e.getMessage());
        }
        return false;
    }
}