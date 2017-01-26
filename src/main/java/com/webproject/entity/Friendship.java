package com.webproject.entity;

import java.util.Date;

/**
 * Объектное представление сущности Friendship.
 */
public class Friendship {
    private int userOne;
    private int userTwo;
    private int status;
    private Date dateRequest;

    public Friendship(int userOne, int userTwo, int status, Date dateRequest) {
        this.userOne = userOne;
        this.userTwo = userTwo;
        this.status = status;
        this.dateRequest = dateRequest;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(Date dateRequest) {
        this.dateRequest = dateRequest;
    }
}
