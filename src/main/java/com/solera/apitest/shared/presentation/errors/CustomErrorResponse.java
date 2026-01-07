package com.solera.apitest.shared.presentation.errors;

public record CustomErrorResponse(
        int status,
        String message
){}
