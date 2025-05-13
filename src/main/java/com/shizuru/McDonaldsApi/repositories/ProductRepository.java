package com.shizuru.McDonaldsApi.repositories;

import com.shizuru.McDonaldsApi.dtos.ProductsDTO;
import com.shizuru.McDonaldsApi.models.CategoryModel;
import com.shizuru.McDonaldsApi.models.ProductModel;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {

    default ProductModel createProduct(@Valid ProductsDTO product) {
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(product, productModel);
        return save(productModel);
    }
    default List<ProductModel> findAllProducts() {
        return findAll();
    }
    default Optional<ProductModel> findById(UUID id) {
        return findById(id);
    }
    default ProductModel updateProduct(UUID productId, ProductsDTO productsDTO) {
        return findById(productId).map(existingProduct ->{
            BeanUtils.copyProperties(productsDTO, existingProduct);
            return save(existingProduct);
        }).orElseThrow();
    }
    default void deleteProduct(UUID productId) {
        if(!existsById(productId)) {
            throw new EntityNotFoundException("Product not found.");
        }
        deleteById(productId);

    }




}
