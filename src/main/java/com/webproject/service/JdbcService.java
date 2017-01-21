package com.webproject.service;

import com.webproject.entity.User;
import com.webproject.exceptions.InvalidPasswordException;

import java.sql.*;

public class JdbcService {

    private static final String TABLE_NAME = "USERS";
    private static final String PASSWORD_COLUMN = "USER_PASS";

    public User find(Connection conn, String login, String password) throws InvalidPasswordException, SQLException {
        String passwordFromDB = getValueFromDB(conn, PASSWORD_COLUMN, TABLE_NAME, PASSWORD_COLUMN, login);
        System.out.println("passwordFromDB = " + passwordFromDB);
        if (passwordFromDB.equals(password)) {
            System.out.println(login + " " + passwordFromDB);
            return new User(login, passwordFromDB);
        } else
            throw new InvalidPasswordException("Invalid login or password.");
    }

    /**
     * взять значение из БД
     */
    public static final String SELECT_ANYTHING = "SELECT USER_PASS FROM USERS WHERE USER_NAME = ?;"; //TODO сделать запрос более гибким

    public String getValueFromDB(Connection conn, String what, String tableName, String columnName, String value) throws SQLException {
        String result = "";
        try (PreparedStatement statement = conn.prepareStatement(SELECT_ANYTHING)) {
//            statement.setString(1, what);
//            statement.setString(2, tableName);
//            statement.setString(3, columnName);
            statement.setString(1, value);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return resultSet.getString(what);
                }
            }
        } catch (SQLException e) {
            System.out.println("Can't get connection: " + e.getMessage());
        } finally {
            conn.close();
        }
        return result;
    }


}