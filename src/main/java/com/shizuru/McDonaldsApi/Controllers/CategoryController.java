package com.shizuru.McDonaldsApi.Controllers;

import com.shizuru.McDonaldsApi.dtos.CategoryDTO;
import com.shizuru.McDonaldsApi.models.CategoryModel;
import com.shizuru.McDonaldsApi.services.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryModel> createCategory(@RequestBody @Valid CategoryDTO categoryDTO) {
        CategoryModel categoryModel = categoryService.createCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.OK).body(categoryModel);
    }
    @GetMapping
    public ResponseEntity<List<CategoryModel>> findAllCategories() {
        return ResponseEntity.ok(categoryService.findAllCategories());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryModel> findCategoryById(@PathVariable UUID id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryModel> updateCategory(@PathVariable UUID id, @Valid CategoryDTO categoryDTO) {
       return ResponseEntity.ok(categoryService.updateCategory(id, categoryDTO)) ;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryModel> deleteCategory(@PathVariable UUID id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }



}
