package com.solera.apitest.users.domain.exceptions;

public class UserCannotLoginException extends RuntimeException {
    public UserCannotLoginException(String message) {
        super(message);
    }
}
