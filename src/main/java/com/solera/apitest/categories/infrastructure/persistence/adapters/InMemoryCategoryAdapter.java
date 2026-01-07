package com.solera.apitest.categories.infrastructure.persistence.adapters;

import com.solera.apitest.categories.domain.models.Category;
import com.solera.apitest.categories.domain.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class InMemoryCategoryAdapter implements CategoryRepository {

    private final List<Category> products = new ArrayList<>(List.of(new Category(1L, "Compras", ""), new Category(2L, "Comida", "")));

    @Override
    public Category save(Category category) {
        products.add(category);
        return category;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    @Override
    public List<Category> findAll() {
        return products;
    }

    @Override
    public void deleteById(Long id) {
        products.removeIf((a) -> a.getId().equals(id));
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
