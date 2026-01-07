package com.solera.apitest.product.presentation.dtos;

public record ProductResponseDto(
        Long id,
        String name,
        Double price,
        String description,
        String categoryName
) {
    public ProductResponseDto setCategory(String categoryName) {
        return new ProductResponseDto(
                this.id(),
                this.name(),
                this.price(),
                this.description(),
                categoryName
        );
    }

}
