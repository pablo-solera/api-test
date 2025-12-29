package com.solera.apitest.product.application.usecases;

import com.solera.apitest.categories.domain.exceptions.CategoryNotFoundException;
import com.solera.apitest.categories.domain.models.Category;
import com.solera.apitest.categories.domain.repositories.CategoryRepository;
import com.solera.apitest.product.application.mappers.ProductMapper;
import com.solera.apitest.product.domain.models.Product;
import com.solera.apitest.product.domain.repositories.ProductRepository;
import com.solera.apitest.product.presentation.dtos.CreateProductRequestDto;
import com.solera.apitest.product.presentation.dtos.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductUseCase {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;


    public ProductResponseDto execute(CreateProductRequestDto request) {

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException(request.getCategoryId()));

        Product product = productMapper.toDomain(request,category);

        var savedProduct = productRepository.save(product);

        return productMapper.toDto(savedProduct);

       /* return new ProductResponseDto(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getCategory().getName()
        );*/
    }
}
