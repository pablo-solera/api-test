package com.solera.apitest.categories.presentation.dtos;

import lombok.Data;

@Data
public class CategoryResponseDto {
    private Long id;
    private String name;
    private String description;
}
