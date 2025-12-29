package com.solera.apitest.categories.presentation;

import com.solera.apitest.categories.application.usecases.GetAllCategoriesUseCase;
import com.solera.apitest.categories.domain.models.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final GetAllCategoriesUseCase getAllCategoriesUseCase;

    @GetMapping("")
    ResponseEntity<List<Category>> getAllCategories(){

        var categoryList = getAllCategoriesUseCase.execute();
        return ResponseEntity.ok(categoryList);
    }

    @GetMapping("{id}")
    ResponseEntity<Optional<Category>> getCategoryById(@PathVariable("id") Long id){

        return ResponseEntity.ok().build();
    }
}
