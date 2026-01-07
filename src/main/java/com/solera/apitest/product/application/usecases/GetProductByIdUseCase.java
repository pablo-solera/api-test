package com.solera.apitest.product.application.usecases;

import com.solera.apitest.product.domain.exceptions.ProductNotFoundException;
import com.solera.apitest.product.domain.models.Product;
import com.solera.apitest.product.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetProductByIdUseCase {

    private final ProductRepository productRepository;

    public Product execute(Long id) {

        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
