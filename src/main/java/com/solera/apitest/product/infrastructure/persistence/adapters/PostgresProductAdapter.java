package com.solera.apitest.product.infrastructure.persistence.adapters;

import com.solera.apitest.product.application.mappers.ProductDtoMapper;
import com.solera.apitest.product.domain.models.Product;
import com.solera.apitest.product.domain.repositories.ProductRepository;
import com.solera.apitest.product.infrastructure.mappers.ProductEntityMapper;
import com.solera.apitest.product.infrastructure.persistence.entities.ProductEntity;
import com.solera.apitest.product.infrastructure.repositories.JpaProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostgresProductAdapter implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;
    private final ProductEntityMapper productEntityMapper;

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productEntityMapper.toEntity(product);
        ProductEntity savedProductEntity = jpaProductRepository.save(productEntity);
        return productEntityMapper.toDomain(savedProductEntity);
    }

    @Override
    public Optional<Product> findById(Long id) {
        ProductEntity productEntity = jpaProductRepository.findById(id).orElseThrow();
        Product product = productEntityMapper.toDomain(productEntity);

        return Optional.of(product);
    }

    @Override
    public List<Product> findAll() {
        return List.of();
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
