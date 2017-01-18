package com.webproject.exceptions;

public class AnythingWithDataBaseConnectionException extends Exception {
    public AnythingWithDataBaseConnectionException() {
        super();
    }

    public AnythingWithDataBaseConnectionException(String message) {
        super(message);
    }

    public AnythingWithDataBaseConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
