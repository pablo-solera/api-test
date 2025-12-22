package com.solera.apitest.product.infrastructure;

import com.solera.apitest.product.application.GetAllProductsUseCase;
import com.solera.apitest.product.application.GetProductByIdUseCase;
import com.solera.apitest.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final GetAllProductsUseCase getAllProductsUseCase;
    private final GetProductByIdUseCase getProductByIdUseCase;

    @GetMapping("")
    List<Product> getAllProducts(){
        return getAllProductsUseCase.execute();
    }

    @GetMapping("{id}")
    Optional<Product> getProductById(@PathVariable("id") Long id){
        return  getProductByIdUseCase.execute(id);
    }
}
