package com.solera.apitest.product.application;

import com.solera.apitest.product.domain.Product;
import com.solera.apitest.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetProductByIdUseCase {

    private final ProductRepository productRepository;

    public Optional<Product> execute(Long id){
        return productRepository.getById(id);
    }
}
