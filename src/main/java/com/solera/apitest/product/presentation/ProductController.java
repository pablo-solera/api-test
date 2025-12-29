package com.solera.apitest.product.presentation;

import com.solera.apitest.product.application.usecases.CreateProductUseCase;
import com.solera.apitest.product.application.usecases.GetAllProductsUseCase;
import com.solera.apitest.product.application.usecases.GetProductByIdUseCase;
import com.solera.apitest.product.domain.models.Product;
import com.solera.apitest.product.presentation.dtos.CreateProductRequestDto;
import com.solera.apitest.product.presentation.dtos.ProductResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final GetAllProductsUseCase getAllProductsUseCase;
    private final GetProductByIdUseCase getProductByIdUseCase;
    private final CreateProductUseCase createProductUseCase;

    @GetMapping("")
    List<Product> getAllProducts() {
        return getAllProductsUseCase.execute();
    }

    @GetMapping("{id}")
    Optional<Product> getProductById(@PathVariable("id") Long id) {
        return getProductByIdUseCase.execute(id);
    }

    @PostMapping("")
    ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody CreateProductRequestDto request) {

        ProductResponseDto productResponseDto = createProductUseCase.execute(request);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productResponseDto.id())
                .toUri();

        return ResponseEntity.created(location).body(productResponseDto);
    }
}
