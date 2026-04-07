package com.solera.apitest.users.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    ACTIVE("ACTIVE", "User is active and can access the system"),
    INACTIVE("INACTIVE", "User is inactive and cannot access the system"),
    LOCKED("LOCKED", "User account is locked due to security reasons"),
    PENDING_VERIFICATION("PENDING_VERIFICATION", "User registered but email not verified"),
    SUSPENDED("SUSPENDED", "User account temporarily suspended");

    private final String name;
    private final String description;

    public boolean canLogin() {
        return this == ACTIVE;
    }

    public boolean canBeActivated() {
        return this == INACTIVE || this == PENDING_VERIFICATION;
    }

    public boolean requiresAdminIntervention() {
        return this == LOCKED || this == SUSPENDED;
    }

    public boolean isBlocked() {
        return this == LOCKED || this == SUSPENDED;
    }
}
