package com.solera.apitest.categories.application.usecases;

import com.solera.apitest.categories.domain.models.Category;
import com.solera.apitest.categories.domain.repositories.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateCategoryUseCaseTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CreateCategoryUseCase createCategoryUseCase;


    @Test
    void create_category_without_id(){
        Category categoryToCreate = Category.builder()
                .name("Nombre")
                .description("")
                .build();

        when(createCategoryUseCase.execute(categoryToCreate)).thenReturn(categoryToCreate);

        createCategoryUseCase.execute(categoryToCreate);

        assertNotNull(categoryToCreate);
        assertEquals("Nombre", categoryToCreate.getName());
    }





}