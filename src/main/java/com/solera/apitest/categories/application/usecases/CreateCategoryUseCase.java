package com.solera.apitest.categories.application.usecases;

import com.solera.apitest.categories.domain.models.Category;
import com.solera.apitest.categories.domain.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCategoryUseCase {

    private final CategoryRepository categoryRepository;

    public Category execute(Category category){

        return categoryRepository.save(category);
    }
}
