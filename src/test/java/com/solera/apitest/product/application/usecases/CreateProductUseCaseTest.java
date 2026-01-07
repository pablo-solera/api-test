package com.solera.apitest.product.application.usecases;

import com.solera.apitest.categories.domain.exceptions.CategoryNotFoundException;
import com.solera.apitest.categories.domain.repositories.CategoryRepository;
import com.solera.apitest.product.application.mappers.ProductDtoMapper;
import com.solera.apitest.product.domain.models.Product;
import com.solera.apitest.product.domain.repositories.ProductRepository;
import com.solera.apitest.product.presentation.dtos.CreateProductRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateProductUseCaseTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CreateProductUseCase useCase;


    @Test
    void should_create_product_when_category_exists() {
        Product product = new Product();
        product.setName("Laptop");
        product.setPrice(1500.0);
        product.setCategoryId(1L);

        when(categoryRepository.existsById(1L)).thenReturn(true);
        when(productRepository.save(product)).thenReturn(product);

        Product result = useCase.execute(product);

        assertNotNull(result);
        assertEquals("Laptop", result.getName());
        assertEquals(1500.0, result.getPrice());
        assertEquals(1L, result.getCategoryId());

        verify(categoryRepository).existsById(1L);
        verify(productRepository).save(product);
    }

    @Test
    void should_throw_exception_when_category_does_not_exist() {
        Product product = new Product();
        product.setName("Laptop");
        product.setPrice(1500.0);
        product.setCategoryId(99L);

        when(categoryRepository.existsById(99L)).thenReturn(false);

        assertThrows(
                CategoryNotFoundException.class,
                () -> useCase.execute(product)
        );

        verify(productRepository, never()).save(any());
    }

}