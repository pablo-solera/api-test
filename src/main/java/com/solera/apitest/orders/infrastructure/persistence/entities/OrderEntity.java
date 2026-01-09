package com.solera.apitest.orders.infrastructure.persistence.entities;

import com.solera.apitest.categories.infrastructure.persistence.entities.CategoryEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;




}
