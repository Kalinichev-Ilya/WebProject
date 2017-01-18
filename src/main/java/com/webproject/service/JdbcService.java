package com.webproject.service;

import com.webproject.db.JdbcConnection;
import com.webproject.entity.User;
import com.webproject.exceptions.AnythingWithDataBaseConnectionException;
import com.webproject.exceptions.InvalidPasswordException;

import java.sql.*;

public class JdbcService {

    public Connection getConnection() throws AnythingWithDataBaseConnectionException {
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

    private static final String TABLE_NAME = "USERS";
    private static final String PASSWORD_COLUMN = "PASSWORD";

    public User find(Connection con, String login, String password) throws InvalidPasswordException {

        String passwordFromDB = getValueFromDB(con, PASSWORD_COLUMN, TABLE_NAME, PASSWORD_COLUMN, login);
        if (passwordFromDB.equals(password)) {
            System.out.println(login + " " + passwordFromDB);
            return new User(login, passwordFromDB);
//        }
//        return new User("error", "error");
        } else
            throw new InvalidPasswordException("Invalid login or password.");
    }

//    /**
//     * проверка ПАРОЛЯ по ЛОГИНУ
//     */
//    private static final String SELECT_USER_BY_LOGIN = "SELECT PASSWORD FROM USERS WHERE LOGIN = ?;";
//
//    public boolean validateLoginFromDB(Connection con) {
//        try (PreparedStatement statement = con.prepareStatement(SELECT_USER_BY_LOGIN)) {
//            statement.setString(1, userName);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                while (resultSet.next()) {
//                    String passwordFromDB = resultSet.getString(COLUMN_PASSWORD);
//                    if (passwordFromDB.equals(password)) {
//                        return true;
//                    } else
//                        throw new InvalidPasswordException("Invalid password!");
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println("Can't get connection: " + e.getMessage());
//        }
//        return false;
//    }
//
//
//    /**
//     * проверка НАЛИЧИЯ ключа АВТОРИЗАЦИИ
//     */
//
//    public static final String SELECT_AUTH_KEY = "SELECT AUTH_KEY FROM AUTHORIZATION WHERE AUTH_KEY = ?;";
//
//    public boolean validateAuthKeyFromDB(Connection con, String auth_keyValue) {
//
//        try (PreparedStatement statement = con.prepareStatement(SELECT_AUTH_KEY)) {
//            statement.setString(1, auth_keyValue);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                while (resultSet.next()) {
//                    String authKeyFromDB = resultSet.getString(auth_keyValue); /*Ключ существует!*/
//                    if (authKeyFromDB != null) {
//                        return true;
//                    } else
//                        return false;
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println("Can't get connection: " + e.getMessage());
//        }
//        return false;
//    }

    /**
     * взять значение из БД
     */
    public static final String SELECT_ANYTHING = "SELECT PASSWORD FROM USERS WHERE LOGIN = ?;"; //TODO сделать запрос более гибким

    public String getValueFromDB(Connection con, String what, String tableName, String columnName, String value) {
        String result = "";
        try (PreparedStatement statement = con.prepareStatement(SELECT_ANYTHING)) {
//            statement.setString(1, what);
//            statement.setString(2, tableName);
//            statement.setString(3, columnName);
            statement.setString(1, value);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return resultSet.getString(what);
//                    System.out.println(resultSet.getString(what));
                }
            }
        } catch (SQLException e) {
            System.out.println("Can't get connection: " + e.getMessage());
        }
        return result;
    }


}