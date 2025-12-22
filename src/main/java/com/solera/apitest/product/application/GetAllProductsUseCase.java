package com.solera.apitest.product.application;

import com.solera.apitest.product.domain.Product;
import com.solera.apitest.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllProductsUseCase {

    private final ProductRepository productRepository;

    public List<Product> execute(){
        return productRepository.getAll();
    }
}
