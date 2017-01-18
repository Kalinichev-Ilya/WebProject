package com.webproject.exceptions;

public class ExistsUserException extends AnythingWithDataBaseConnectionException {

    public ExistsUserException() {
        super();
    }

    public ExistsUserException(String message) {
        super(message);
    }

    public ExistsUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
