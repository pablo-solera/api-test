package com.solera.apitest.categories.application.mappers;

import com.solera.apitest.categories.domain.models.Category;
import com.solera.apitest.categories.presentation.dtos.CategoryResponseDto;
import com.solera.apitest.categories.presentation.dtos.CreateCategoryRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryDtoMapper {

    @Mapping(target = "id", ignore = true)
    Category toDomain(CreateCategoryRequestDto dto);

    CategoryResponseDto toDto(Category category);

}
