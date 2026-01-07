package com.solera.apitest.product.application.usecases;

import com.solera.apitest.categories.domain.exceptions.CategoryNotFoundException;
import com.solera.apitest.categories.domain.repositories.CategoryRepository;
import com.solera.apitest.product.domain.models.Product;
import com.solera.apitest.product.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductUseCase {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Product execute(Product product) {

        if(!categoryRepository.existsById(product.getCategoryId())){
            throw new CategoryNotFoundException(product.getCategoryId());
        }

        return productRepository.save(product);
    }
}
