package com.solera.apitest.categories.application.usecases;

import com.solera.apitest.categories.domain.models.Category;
import com.solera.apitest.categories.domain.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCategoryUseCase {

    private final CategoryRepository categoryRepository;

    public void execute(Long id){

        categoryRepository.deleteById(id);

    }
}
