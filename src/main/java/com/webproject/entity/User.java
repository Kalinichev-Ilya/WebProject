package com.webproject.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Объектное представление сущности User.
 */
public class User implements Serializable {
    private int userId;
    private String login;
    private String password;
    private Date dateRegistration;
    private String role;

    public User(String login, String password, Date dateRegistration, String role) {
        this.login = login;
        this.password = password;
        this.dateRegistration = dateRegistration;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
