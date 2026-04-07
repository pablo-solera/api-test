package com.solera.apitest.users.domain.exceptions;

public class UserTemporarilyLockedException extends RuntimeException {
    public UserTemporarilyLockedException(String message) {
        super(message);
    }
}
