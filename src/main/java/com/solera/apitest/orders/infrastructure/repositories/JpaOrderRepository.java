package com.solera.apitest.orders.infrastructure.repositories;


import com.solera.apitest.orders.infrastructure.persistence.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderRepository extends JpaRepository<OrderEntity, Long> {
}
