package com.solera.apitest.product.presentation;

import com.solera.apitest.categories.application.usecases.GetCategoryByIdUseCase;
import com.solera.apitest.product.application.mappers.ProductDtoMapper;
import com.solera.apitest.product.application.usecases.CreateProductUseCase;
import com.solera.apitest.product.application.usecases.GetAllProductsUseCase;
import com.solera.apitest.product.application.usecases.GetProductByIdUseCase;
import com.solera.apitest.product.domain.exceptions.ProductNotFoundException;
import com.solera.apitest.product.domain.models.Product;
import com.solera.apitest.product.presentation.dtos.CreateProductRequestDto;
import com.solera.apitest.product.presentation.dtos.ProductResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.http.server.LocalTestWebServer.get;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private  GetAllProductsUseCase getAllProductsUseCase;

    @Mock
    private  GetProductByIdUseCase getProductByIdUseCase;

    @Mock
    private  GetCategoryByIdUseCase getCategoryByIdUseCase;

    @Mock
    private  CreateProductUseCase createProductUseCase;

    @Mock
    private ProductDtoMapper productDtoMapper;

    @InjectMocks
    ProductController productController;


   /* @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllProducts() {
    }

    @Test
    void should_return_product_by_id() {
    }

    @Test
    void createProduct() {
    }*/


}