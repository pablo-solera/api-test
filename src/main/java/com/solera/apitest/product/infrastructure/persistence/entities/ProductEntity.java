package com.solera.apitest.product.infrastructure.persistence.entities;

import com.solera.apitest.categories.infrastructure.persistence.entities.CategoryEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, length = 100)
    String name;

    @Nullable
    @Column(length = 500)
    String description;

    @Column(nullable = false)
    Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    CategoryEntity category;


}
