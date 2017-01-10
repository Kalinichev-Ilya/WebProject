package com.webproject.dao.exceptions;

public class NoSuchEntityException extends DaoBusinessExeption {
    public NoSuchEntityException(String message){
        super(message);
    }

    public NoSuchEntityException(String message, Throwable cause){
        super(message, cause);
    }
}
