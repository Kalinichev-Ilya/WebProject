package com.webproject.exception;

public class ExistsUserSignUpException extends SignUpException {

    public ExistsUserSignUpException() {
        super();
    }

    public ExistsUserSignUpException(String message) {
        super(message);
    }

    public ExistsUserSignUpException(String message, Throwable cause) {
        super(message, cause);
    }
}
