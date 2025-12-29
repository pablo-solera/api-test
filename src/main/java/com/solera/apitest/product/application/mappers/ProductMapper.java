package com.solera.apitest.product.application.mappers;

import com.solera.apitest.categories.domain.models.Category;
import com.solera.apitest.product.domain.models.Product;
import com.solera.apitest.product.infrastructure.persistence.entities.ProductEntity;
import com.solera.apitest.product.presentation.dtos.CreateProductRequestDto;
import com.solera.apitest.product.presentation.dtos.ProductResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    // DTO de request → Entidad de dominio
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "description", source = "dto.description")
    @Mapping(target = "category", source = "category")
    Product toDomain(CreateProductRequestDto dto, Category category);

    // Entidad de dominio → DTO de response
    @Mapping(target = "id", source = "product.id")
    @Mapping(target = "name", source = "product.name")
    @Mapping(target = "categoryName", source = "product.category.name")
    ProductResponseDto toDto(Product product);

    ProductEntity toEntity(Product product);

    Product toDomain(ProductEntity entity, Category category);
}
