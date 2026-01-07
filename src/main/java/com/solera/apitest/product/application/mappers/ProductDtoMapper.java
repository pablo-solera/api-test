package com.solera.apitest.product.application.mappers;

import com.solera.apitest.product.domain.models.Product;
import com.solera.apitest.product.presentation.dtos.CreateProductRequestDto;
import com.solera.apitest.product.presentation.dtos.ProductResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductDtoMapper {

    @Mapping(target = "id", ignore = true)
    Product toDomain(CreateProductRequestDto dto);

    @Mapping(target = "categoryName", ignore = true)
    ProductResponseDto toDto(Product product);
}
