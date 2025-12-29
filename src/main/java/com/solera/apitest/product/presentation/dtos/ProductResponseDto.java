package com.solera.apitest.product.presentation.dtos;

public record ProductResponseDto (
     Long id,
     String name,
     Double price,
     String description,
     String categoryName
){}
