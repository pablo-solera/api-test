package com.solera.apitest.categories.application.usecases;

import com.solera.apitest.categories.domain.exceptions.CategoryNotFoundException;
import com.solera.apitest.categories.domain.models.Category;
import com.solera.apitest.categories.domain.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetCategoryByIdUseCase {

    private final CategoryRepository categoryRepository;

    public Category execute(Long id){
        return categoryRepository.findById(id)
                .orElseThrow( () -> new CategoryNotFoundException(id));
    }
}
