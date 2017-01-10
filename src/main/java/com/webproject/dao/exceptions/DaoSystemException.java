package com.webproject.dao.exceptions;

public class DaoSystemException extends DaoException {
    public DaoSystemException(String message){
        super(message);
    }

    public DaoSystemException(String message, Throwable cause){
        super(message, cause);
    }
}
