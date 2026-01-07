package com.solera.apitest.product.infrastructure.persistence.adapters;

import com.solera.apitest.product.domain.models.Product;
import com.solera.apitest.product.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Primary
@RequiredArgsConstructor
public class InMemoryProductAdapter implements ProductRepository {

    private final List<Product> products = new ArrayList<>(List.of(
            new Product(1L, "Pollo", "Pollo deshuesado", 2.15, 1L)
            , new Product(2L, "Carne picada", "Carne picada para hamburguesas", 3.45, 1L)
            , new Product(3L, "Paté de pato", "Higado de pato a las finas hierbas", 6.0, 1L)
            , new Product(4L, "Pan", "Barra de pan", 0.99, 1L)
    )
    );


    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
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
        products.removeIf(p -> p.getId().equals(id));
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
