package com.solera.apitest.product.presentation;

import com.solera.apitest.categories.application.usecases.GetCategoryByIdUseCase;
import com.solera.apitest.categories.domain.models.Category;
import com.solera.apitest.product.application.mappers.ProductDtoMapper;
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
    private final GetCategoryByIdUseCase getCategoryByIdUseCase;
    private final CreateProductUseCase createProductUseCase;
    private final ProductDtoMapper productDtoMapper;

    @GetMapping("")
    ResponseEntity<List<Product>> getAllProducts() {

        List<Product> products = getAllProductsUseCase.execute();


        return ResponseEntity.ok(products);
    }

    @GetMapping("{id}")
    ResponseEntity<ProductResponseDto> getProductById(@PathVariable("id") Long id) {

        Product product = getProductByIdUseCase.execute(id);

        Category category = getCategoryByIdUseCase.execute(product.getCategoryId());

        ProductResponseDto response = productDtoMapper.toDto(product);
        response = response.setCategory(category.getName());



        return ResponseEntity.ok(response);
    }

    @PostMapping("")
    ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody CreateProductRequestDto request) {

        Product product = createProductUseCase.execute(productDtoMapper.toDomain(request));

        Category category = getCategoryByIdUseCase.execute(product.getCategoryId());

        ProductResponseDto response = productDtoMapper.toDto(product);
        response = response.setCategory(category.getName());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                // .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }
}
