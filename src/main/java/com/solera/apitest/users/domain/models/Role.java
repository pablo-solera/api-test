package com.solera.apitest.users.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    ADMIN("ADMIN", "Administrator with full access"),
    CUSTOMER("CUSTOMER", "Regular customer with limited access"),
    GUEST("GUEST", "Guest user with minimal access"),
    SUPPORT("SUPPORT", "Support staff with access to customer data");

    private final String name;
    private final String description;
}
