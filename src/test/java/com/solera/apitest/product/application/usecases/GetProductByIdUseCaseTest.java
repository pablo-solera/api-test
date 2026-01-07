package com.solera.apitest.product.application.usecases;

import com.solera.apitest.categories.domain.repositories.CategoryRepository;
import com.solera.apitest.product.domain.exceptions.ProductNotFoundException;
import com.solera.apitest.product.domain.models.Product;
import com.solera.apitest.product.domain.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("GetProductByIdUseCase Tests")
class GetProductByIdUseCaseTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private GetProductByIdUseCase getProductByIdUseCase;

    private Product mockProduct;
    private Long validId;

    @BeforeEach
    void setUp() {
        validId = 1L;
        mockProduct = Product.builder()
                .id(validId)
                .name("Product Test")
                .description("Test Description")
                .price(99.99)
                .build();
    }


    @Test
    @DisplayName("Debe retornar un producto cuando existe con el ID proporcionado")
    void shouldReturnProductWhenIdExists() {
        // Given - Arrange
        when(productRepository.findById(validId))
                .thenReturn(Optional.of(mockProduct));

        // When - Act
        Product result = getProductByIdUseCase.execute(validId);

        // Then - Assert
        assertNotNull(result);
        assertEquals(validId, result.getId());
        assertEquals("Product Test", result.getName());
        assertEquals("Test Description", result.getDescription());
        assertEquals(99.99, result.getPrice());

        verify(productRepository, times(1)).findById(validId);
    }

    @Test
    @DisplayName("Debe lanzar ProductNotFoundException cuando el producto no existe")
    void shouldThrowProductNotFoundExceptionWhenIdDoesNotExist() {
        // Given - Arrange
        Long nonExistentId = 999L;
        when(productRepository.findById(nonExistentId))
                .thenReturn(Optional.empty());

        // When & Then - Act & Assert
        ProductNotFoundException exception = assertThrows(
                ProductNotFoundException.class,
                () -> getProductByIdUseCase.execute(nonExistentId)
        );

        assertEquals("Producto no encontrado con ID: " + nonExistentId, exception.getMessage());
        verify(productRepository, times(1)).findById(nonExistentId);
    }

    @Test
    @DisplayName("Debe lanzar excepción cuando se pasa un ID nulo")
    void shouldThrowExceptionWhenIdIsNull() {
        // When & Then - Act & Assert
        assertThrows(
                ProductNotFoundException.class,
                () -> getProductByIdUseCase.execute(null)
        );
    }

    @Test
    @DisplayName("Debe lanzar excepción cuando se pasa un ID negativo")
    void shouldThrowExceptionWhenIdIsNegative() {
        // Given - Arrange
        Long negativeId = -1L;
        when(productRepository.findById(negativeId))
                .thenReturn(Optional.empty());

        // When & Then - Act & Assert
        assertThrows(
                ProductNotFoundException.class,
                () -> getProductByIdUseCase.execute(negativeId)
        );

        verify(productRepository, times(1)).findById(negativeId);
    }

    @Test
    @DisplayName("Debe llamar al repositorio solo una vez")
    void shouldCallRepositoryOnlyOnce() {
        // Given - Arrange
        when(productRepository.findById(validId))
                .thenReturn(Optional.of(mockProduct));

        // When - Act
        getProductByIdUseCase.execute(validId);

        // Then - Assert
        verify(productRepository, times(1)).findById(validId);
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    @DisplayName("Debe propagar excepción cuando el repositorio falla")
    void shouldPropagateExceptionWhenRepositoryFails() {
        // Given - Arrange
        when(productRepository.findById(validId))
                .thenThrow(new RuntimeException("Database error"));

        // When & Then - Act & Assert
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> getProductByIdUseCase.execute(validId)
        );

        assertEquals("Database error", exception.getMessage());
        verify(productRepository, times(1)).findById(validId);
    }

}