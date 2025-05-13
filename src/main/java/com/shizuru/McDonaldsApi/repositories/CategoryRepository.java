package com.shizuru.McDonaldsApi.repositories;

import com.shizuru.McDonaldsApi.dtos.CategoryDTO;
import com.shizuru.McDonaldsApi.models.CategoryModel;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, UUID> {

    default CategoryModel createCategory(@Valid CategoryDTO category) {
        CategoryModel categoryModel = new CategoryModel();
        BeanUtils.copyProperties(category,categoryModel );
        return save(categoryModel);
    }
    default List<CategoryModel> findAllCategories() {
        return findAll();
    }
    default Optional<CategoryModel> findCategoryById(UUID id) {
        return findById(id);
    }
    default CategoryModel updateCategory(UUID id, CategoryDTO categoryDTO) {
        return findCategoryById(id).map(existingCaregory ->{
                BeanUtils.copyProperties(categoryDTO, existingCaregory);
                return save(existingCaregory);
        }).orElseThrow();
    }

    default void deleteCategoryById(UUID id) {
        if(!existsById(id)) {
            throw new EntityNotFoundException("Category not found.");
        }
        deleteById(id);
    }

}
