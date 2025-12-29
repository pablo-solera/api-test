package com.solera.apitest.product.domain.repositories;

import com.solera.apitest.product.domain.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    Optional<Product> findById(Long id);

    List<Product> findAll();

    List<Product> findByCategoryId(Long categoryId);

    void deleteById(Long id);

    boolean existsById(Long id);

    boolean existsByName(String name);
}
