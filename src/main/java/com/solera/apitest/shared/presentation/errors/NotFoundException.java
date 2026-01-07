package com.solera.apitest.shared.presentation.errors;

public abstract class NotFoundException extends RuntimeException{
    protected NotFoundException(String message){
        super(message);
    }
}
