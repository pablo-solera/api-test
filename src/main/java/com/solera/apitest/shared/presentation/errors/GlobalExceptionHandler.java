package com.solera.apitest.shared.presentation.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomErrorResponse handleNotFound(NotFoundException ex){
        return new CustomErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );
    }
}
