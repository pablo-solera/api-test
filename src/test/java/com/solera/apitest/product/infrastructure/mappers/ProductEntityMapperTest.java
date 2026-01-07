package com.solera.apitest.product.infrastructure.mappers;

import com.solera.apitest.categories.infrastructure.persistence.entities.CategoryEntity;
import com.solera.apitest.product.domain.models.Product;
import com.solera.apitest.product.infrastructure.persistence.entities.ProductEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class ProductEntityMapperTest {

    private final ProductEntityMapper mapper =
            Mappers.getMapper(ProductEntityMapper.class);

    @Test
    void should_map_domain_to_entity_with_category_reference() {

        Product product = new Product();
        product.setId(1L);
        product.setName("Tablet");
        product.setDescription("Android tablet");
        product.setPrice(400.0);
        product.setCategoryId(3L);

        ProductEntity entity = mapper.toEntity(product);

        assertNotNull(entity);
        assertEquals(1L, entity.getId());
        assertEquals("Tablet", entity.getName());
        assertEquals("Android tablet", entity.getDescription());
        assertEquals(400.0, entity.getPrice());

        assertNotNull(entity.getCategory());
        assertEquals(3L, entity.getCategory().getId());
    }

    @Test
    void should_map_entity_to_domain() {
        CategoryEntity category = new CategoryEntity();
        category.setId(7L);
        category.setName("Electronics");

        ProductEntity entity = new ProductEntity();
        entity.setId(2L);
        entity.setName("Monitor");
        entity.setDescription("4K Monitor");
        entity.setPrice(600.0);
        entity.setCategory(category);

        Product product = mapper.toDomain(entity);

        assertNotNull(product);
        assertEquals(2L, product.getId());
        assertEquals("Monitor", product.getName());
        assertEquals("4K Monitor", product.getDescription());
        assertEquals(600.0, product.getPrice());
        assertEquals(7L, product.getCategoryId());
    }
}