package com.solera.apitest.users.domain.models;

import com.solera.apitest.users.domain.exceptions.InvalidEmailException;
import com.solera.apitest.users.domain.exceptions.UserCannotLoginException;
import com.solera.apitest.users.domain.exceptions.UserStatusException;
import com.solera.apitest.users.domain.exceptions.UserTemporarilyLockedException;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Long id;
    private String email;
    private String password;
    private Status status;
    private Role role;
    private int failedLoginAttempts;
    private LocalDateTime lockedUntil;
    private LocalDateTime createdAt;
    private LocalDateTime lastLoginAt;
    private LocalDateTime updatedAt;

    // Métodos de negocio relacionados con el estado
    public void activate() {
        if (!this.status.canBeActivated()) {
            throw new UserStatusException(
                    "Cannot activate user with status: " + this.status
            );
        }
        this.status = Status.ACTIVE;
        this.updatedAt = LocalDateTime.now();
    }

    public void deactivate() {
        if (this.status == Status.ACTIVE) {
            this.status = Status.INACTIVE;
            this.updatedAt = LocalDateTime.now();
        }
    }

    public void lock(String reason) {
        this.status = Status.LOCKED;
        this.lockedUntil = LocalDateTime.now().plusDays(30);
        this.updatedAt = LocalDateTime.now();
    }

    public void unlock() {
        if (this.status == Status.LOCKED) {
            this.status = Status.ACTIVE;
            this.failedLoginAttempts = 0;
            this.lockedUntil = null;
            this.updatedAt = LocalDateTime.now();
        }
    }

    public void suspend(LocalDateTime until) {
        this.status = Status.SUSPENDED;
        this.lockedUntil = until;
        this.updatedAt = LocalDateTime.now();
    }

    public void recordFailedLogin() {
        this.failedLoginAttempts++;
        if (this.failedLoginAttempts >= 5) {
            this.lock("Too many failed login attempts");
        }
    }

    public void recordSuccessfulLogin() {
        this.failedLoginAttempts = 0;
        this.lastLoginAt = LocalDateTime.now();
    }

    public void verifyEmail() {
        if (this.status == Status.PENDING_VERIFICATION) {
            this.status = Status.ACTIVE;
            this.updatedAt = LocalDateTime.now();
        }
    }

    // Validaciones
    public void validateCanLogin() {
        if (!this.status.canLogin()) {
            throw new UserCannotLoginException(
                    "User cannot login with status: " + this.status.getName()
            );
        }

        if (this.lockedUntil != null && LocalDateTime.now().isBefore(this.lockedUntil)) {
            throw new UserTemporarilyLockedException(
                    "User is locked until: " + this.lockedUntil
            );
        }
    }

    private static void validateEmail(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new InvalidEmailException("Invalid email format");
        }
    }


    public boolean isActive() { return status == Status.ACTIVE; }
    public boolean isLocked() { return status.isBlocked(); }
}