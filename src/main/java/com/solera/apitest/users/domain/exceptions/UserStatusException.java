package com.solera.apitest.users.domain.exceptions;

public class UserStatusException extends RuntimeException {
    public UserStatusException(String message) {
        super(message);
    }
}
