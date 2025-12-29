package com.solera.apitest.product.domain.exceptions;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id){
        super("Producto no encontrada con ID: "+ id);
    }
}
