package com.solera.apitest.orders.domain.exceptions;

import com.solera.apitest.shared.presentation.errors.NotFoundException;

public class OrderNotFoundException extends NotFoundException {
    public OrderNotFoundException(Long id) {
        super("Pedido no encontrado con ID: " + id);
    }
}
