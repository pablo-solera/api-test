package com.solera.apitest.categories.infrastructure.mappers;

import com.solera.apitest.categories.domain.models.Category;
import com.solera.apitest.categories.infrastructure.persistence.entities.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {

    CategoryEntity toEntity(Category category);

    Category toDomain(CategoryEntity entity);

}
