package com.solera.apitest.product.presentation.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;

@Data
public class CreateProductRequestDto {

    @NotNull
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100,  message = "El nombre debe tener entre 2 y 200 caracteres")
    private String name;

    @Nullable
    @Length(min = 5, max = 500, message = "La descripción no puede superar los 1000 caracteres")
    private String description;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
    private Double price;

    @NotNull(message = "La categoría es obligatoria")
    @Positive(message = "El ID de categoría debe ser positivo")
    private Long categoryId;
}
