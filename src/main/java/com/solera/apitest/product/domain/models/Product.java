package com.solera.apitest.product.domain;

import com.solera.apitest.categories.domain.models.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Category category;

}
