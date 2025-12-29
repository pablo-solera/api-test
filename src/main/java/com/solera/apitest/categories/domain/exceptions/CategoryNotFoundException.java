package com.solera.apitest.categories.domain.exceptions;

public class CategoryNotFoundException  extends RuntimeException{
    public CategoryNotFoundException(Long id){
        super("Categoría no encontrada con ID: "+ id);
    }
}
