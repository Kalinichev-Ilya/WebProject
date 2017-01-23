package com.webproject.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Объектное представление сущности User.
 */
public class User implements Serializable {

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private Date creationDate;
    private List<Chat> chatsId;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Chat> getChatsId() {
        return chatsId;
    }

    public void setChatsId(List<Chat> chatsId) {
        this.chatsId = chatsId;
    }
}
