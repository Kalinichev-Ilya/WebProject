package com.webproject.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

/**
 * Объектное представление сущности Группа
 */
public class Chat implements Serializable {

    private int privateKey;
    private Calendar date;
    private List<User> members;

    public void setMembers(User user, List<User> members) {
        members.add(user);
        this.members = members;
    }

    public List<User> getMembers() {
        return members;
    }

    public int getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(int privateKey) {
        this.privateKey = privateKey;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}
