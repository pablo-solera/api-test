package com.solera.apitest.product.domain;

import org.springframework.stereotype.Repository;

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
