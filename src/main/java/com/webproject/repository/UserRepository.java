package com.webproject.repository;

import com.webproject.domain.User;
import com.webproject.exception.DataAccessException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepository {

    private final DataSource connectionPool;

    public UserRepository(DataSource connectionPool) {
        this.connectionPool = connectionPool;
    }

    public User save(User user) {
        String sql = "INSERT INTO users(username,password) VALUES (?,?)";

        try (Connection conn = connectionPool.getConnection();
             PreparedStatement psmt = conn.prepareStatement(sql)) {
            psmt.setString(1, user.getLogin());
            psmt.setString(2, user.getPassword());
            psmt.execute();
            return user;
        } catch (SQLException e) {
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public Optional<User> findOne(String username) {
        String sql = "SELECT username, password FROM users WHERE username = ?";

        try (Connection conn = connectionPool.getConnection();
             PreparedStatement psmt = conn.prepareStatement(sql)) {
            psmt.setString(1, username);
            try (ResultSet rs = psmt.executeQuery()) { //TODO Убедиться , что запись одна
                while (rs.next()) {
                    String login = rs.getString(1);
                    String passwordMD5 = rs.getString(2);
                    User user = new User(login, passwordMD5);
                    return Optional.of(user);
                }
            }
            return Optional.empty();
        } catch (SQLException e) {
            return Optional.empty();
        }
    }
}
