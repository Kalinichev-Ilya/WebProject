package com.webproject.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Объектное представление сущности Chat
 */
public class Chat implements Serializable {

    private int chatId;
    private int userOne;
    private int userTwo;
    private Date dateCreation;

    public Chat(int userOne, int userTwo, Date dateCreation) {

        this.userOne = userOne;
        this.userTwo = userTwo;
        this.dateCreation = dateCreation;
    }

    public int getChatId() {
        return chatId;
    }

    public int getUserOne() {
        return userOne;
    }

    public void setUserOne(int userOne) {
        this.userOne = userOne;
    }

    public int getUserTwo() {
        return userTwo;
    }

    public void setUserTwo(int userTwo) {
        this.userTwo = userTwo;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
