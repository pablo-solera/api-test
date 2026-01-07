package com.solera.apitest.product.domain.exceptions;

import com.solera.apitest.shared.presentation.errors.NotFoundException;

public class ProductNotFoundException extends NotFoundException {
    public ProductNotFoundException(Long id){
        super("Producto no encontrado con ID: "+ id);
    }
}
