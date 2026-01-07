package com.solera.apitest.product.infrastructure.mappers;

import com.solera.apitest.categories.infrastructure.persistence.entities.CategoryEntity;
import com.solera.apitest.product.domain.models.Product;
import com.solera.apitest.product.infrastructure.persistence.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

    @Mapping(target = "category", source = "categoryId")
    ProductEntity toEntity(Product product);

    @Mapping(target = "categoryId", source = "category.id")
    Product toDomain(ProductEntity entity);

    default CategoryEntity map(Long categoryId) {
        if (categoryId == null) return null;
        CategoryEntity category = new CategoryEntity();
        category.setId(categoryId);
        return category;
    }
}
