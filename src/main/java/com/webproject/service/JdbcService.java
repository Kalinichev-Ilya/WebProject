package com.webproject.service;

import com.webproject.entity.User;
import com.webproject.exceptions.InvalidPasswordException;

import java.sql.*;

public class JdbcService {

    private static final String PASSWORD_COLUMN = "USER_PASS";

    public User find(Connection conn, String login, String password) throws InvalidPasswordException, SQLException {
        String passwordFromDB = getValueFromDB(conn, PASSWORD_COLUMN);
        System.out.println("passwordFromDB = " + passwordFromDB);//TODO метод поиска в сервисе
        if (passwordFromDB.equals(password) && !passwordFromDB.equals("")) {
            System.out.println(login + " " + passwordFromDB);
            return new User(login, passwordFromDB);//TODO возвращать оба значения из базы
        } else
            throw new InvalidPasswordException("Invalid login or password.");//TODO добавить исключения, юзер не найден
    }

    /**
     * взять значение из БД
     */
    public static final String SELECT_ANYTHING = "SELECT USER_PASS FROM USERS WHERE USER_NAME = ?";

    public String getValueFromDB(Connection conn, String what) throws SQLException {
        String result = "";
        try (PreparedStatement statement = conn.prepareStatement(SELECT_ANYTHING)) {//TODO use Optional
            try (ResultSet resultSet = statement.executeQuery()) {//TODO все что с базой в дао, все что с данными в сервис
                while (resultSet.next()) {
                    return resultSet.getString(what);
                }
            }
        } catch (SQLException e) {
            System.out.println("Can't get connection: " + e.getMessage());
        }
        return result;
    }


}