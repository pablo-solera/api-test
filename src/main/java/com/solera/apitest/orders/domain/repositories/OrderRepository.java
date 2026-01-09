package com.solera.apitest.orders.domain.repositories;

import com.solera.apitest.orders.domain.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findById(Long id);

    List<Order> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);

    boolean existsByName(String name);
}
