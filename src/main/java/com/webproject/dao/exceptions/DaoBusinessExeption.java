package com.webproject.dao.exceptions;

public class DaoBusinessExeption extends DaoException {
    public DaoBusinessExeption(String message){
        super(message);
    }

    public DaoBusinessExeption(String message, Throwable cause){
        super(message, cause);
    }
}
