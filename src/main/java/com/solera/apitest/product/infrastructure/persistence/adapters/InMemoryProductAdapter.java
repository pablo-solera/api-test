package com.solera.apitest.product.infrastructure.repositories;

import com.solera.apitest.product.domain.Product;
import com.solera.apitest.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class InMemoryProductRepository implements ProductRepository {

    private final List<Product> products = new ArrayList<>(List.of(new Product(1L,"Pollo", "Pollo deshuesado",2.0),new Product(2L,"Pollo", "Pollo deshuesado",2.0)));


    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public List<Product> findByCategoryId(Long categoryId) {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public boolean existsByName(String name) {
        return false;
    }
}
