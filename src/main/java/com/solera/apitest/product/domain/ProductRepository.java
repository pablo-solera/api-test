package com.solera.apitest.product.domain;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Optional<Product> getById(Long id);
    List<Product> getAll();
}
