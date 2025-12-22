package com.solera.apitest.product.infrastructure;

import com.solera.apitest.product.domain.Product;
import com.solera.apitest.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemoryProductRepository implements ProductRepository {

    private final List<Product> products = new ArrayList<>(List.of(new Product(1L,"Pollo", "Pollo deshuesado",2.0),new Product(2L,"Pollo", "Pollo deshuesado",2.0)));

    @Override
    public Optional<Product> getById(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}
