package com.solera.apitest.categories.presentation;

import com.solera.apitest.categories.application.mappers.CategoryDtoMapper;
import com.solera.apitest.categories.application.usecases.CreateCategoryUseCase;
import com.solera.apitest.categories.application.usecases.DeleteCategoryUseCase;
import com.solera.apitest.categories.application.usecases.GetAllCategoriesUseCase;
import com.solera.apitest.categories.application.usecases.GetCategoryByIdUseCase;
import com.solera.apitest.categories.domain.models.Category;
import com.solera.apitest.categories.presentation.dtos.CategoryResponseDto;
import com.solera.apitest.categories.presentation.dtos.CreateCategoryRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final GetAllCategoriesUseCase getAllCategoriesUseCase;
    private final GetCategoryByIdUseCase getCategoryByIdUseCase;
    private final CreateCategoryUseCase createCategoryUseCase;
    private final DeleteCategoryUseCase deleteCategoryUseCase;
    private final CategoryDtoMapper categoryDtoMapper;

    @GetMapping("")
    ResponseEntity<List<Category>> getAllCategories() {

        var categoryList = getAllCategoriesUseCase.execute();
        return ResponseEntity.ok(categoryList);
    }

    @GetMapping("{id}")
    ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable("id") Long id) {

        Category category = getCategoryByIdUseCase.execute(id);

        CategoryResponseDto response = categoryDtoMapper.toDto(category);

        return ResponseEntity.ok(response);
    }

    @PostMapping("")
    ResponseEntity<CategoryResponseDto> createCategory(@RequestBody @Valid CreateCategoryRequestDto requestDto) {

        Category category = createCategoryUseCase.execute(categoryDtoMapper.toDomain(requestDto));
        CategoryResponseDto response = categoryDtoMapper.toDto(category);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                // .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();

        return ResponseEntity.created(location).body(response);

    }

    @DeleteMapping("{id}")
    void deleteCategory(@PathVariable("id") Long id) {
        deleteCategoryUseCase.execute(id);
    }
}
