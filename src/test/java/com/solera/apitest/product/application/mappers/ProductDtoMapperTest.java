package com.solera.apitest.product.application.mappers;

import com.solera.apitest.product.domain.models.Product;
import com.solera.apitest.product.presentation.dtos.CreateProductRequestDto;
import com.solera.apitest.product.presentation.dtos.ProductResponseDto;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class ProductDtoMapperTest {

    private final ProductDtoMapper mapper =
            Mappers.getMapper(ProductDtoMapper.class);

    @Test
    void should_map_create_dto_to_domain() {

        CreateProductRequestDto dto = new CreateProductRequestDto();
        dto.setName("Laptop");
        dto.setDescription("Gaming laptop");
        dto.setPrice(1500.0);
        dto.setCategoryId(10L);

        Product product = mapper.toDomain(dto);

        assertNotNull(product);
        assertNull(product.getId()); // ignore OK
        assertEquals("Laptop", product.getName());
        assertEquals("Gaming laptop", product.getDescription());
        assertEquals(1500.0, product.getPrice());
        assertEquals(10L, product.getCategoryId());
    }

    @Test
    void should_map_domain_to_dto() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Phone");
        product.setDescription("Smartphone");
        product.setPrice(800.0);
        product.setCategoryId(5L);

        ProductResponseDto dto = mapper.toDto(product);

        assertNotNull(dto);
        assertEquals(1L, dto.id());
        assertEquals("Phone", dto.name());
        assertEquals("Smartphone", dto.description());
        assertEquals(800.0, dto.price());
        // assertEquals(5L, dto.getCategoryId());
        assertNull(dto.categoryName()); // ignorado intencionalmente
    }
}