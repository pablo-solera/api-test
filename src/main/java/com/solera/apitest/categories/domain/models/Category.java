package com.solera.apitest.categories.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    Long id;
    String name;
    String description;
}
