package com.solera.apitest.categories.domain.exceptions;

import com.solera.apitest.shared.presentation.errors.NotFoundException;

public class CategoryNotFoundException extends NotFoundException {
    public CategoryNotFoundException(Long id){
        super("Categoría no encontrada con ID: "+ id);
    }
}
