package com.shizuru.McDonaldsApi.services;

import com.shizuru.McDonaldsApi.dtos.CategoryDTO;
import com.shizuru.McDonaldsApi.models.CategoryModel;
import com.shizuru.McDonaldsApi.repositories.CategoryRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryModel createCategory(@Valid CategoryDTO category) {
        return categoryRepository.createCategory(category);
    }
    public List<CategoryModel> findAllCategories() {
        return categoryRepository.findAllCategories();
    }
    public CategoryModel findById(UUID id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

    }
    public CategoryModel updateCategory(UUID id, CategoryDTO categoryDTO) {
       return categoryRepository.updateCategory(id, categoryDTO);
    }
    public void deleteCategory(UUID id) {
        categoryRepository.deleteCategoryById(id);
    }

}
