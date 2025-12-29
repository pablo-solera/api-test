package com.solera.apitest.product.infrastructure.repositories;


import com.solera.apitest.product.infrastructure.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaProductRepository extends JpaRepository<ProductEntity,Long> {

    // Buscar productos por categoría (clave para relación unidireccional)
    List<ProductEntity> findByCategoryId(Long categoryId);

    // Buscar por nombre de categoría
    List<ProductEntity> findByCategoryName(String categoryName);

    // Buscar productos con su categoría (evita N+1)
    @Query("SELECT p FROM ProductEntity p JOIN FETCH p.category")
    List<ProductEntity> findAllWithCategory();

    // Buscar un producto con su categoría
    @Query("SELECT p FROM ProductEntity p JOIN FETCH p.category WHERE p.id = :id")
    ProductEntity findByIdWithCategory(@Param("id") Long id);

    // Contar productos por categoría
    long countByCategoryId(Long categoryId);

    // Verificar si existe producto con nombre
    boolean existsByName(String name);
}
