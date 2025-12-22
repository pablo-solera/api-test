package com.solera.apitest.product.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    Long id;
    String name;
    String description;
    Double price;
}
