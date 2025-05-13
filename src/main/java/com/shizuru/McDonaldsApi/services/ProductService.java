package com.shizuru.McDonaldsApi.services;

import com.shizuru.McDonaldsApi.dtos.ProductsDTO;
import com.shizuru.McDonaldsApi.models.ProductModel;
import com.shizuru.McDonaldsApi.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public ProductModel addProduct(@Valid ProductsDTO product) {
        return productRepository.createProduct(product);
    }
    public List<ProductModel> getAllProducts() {
        return productRepository.findAllProducts();
    }
    public ProductModel getProductById(UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }
    public ProductModel updateProduct(UUID id, ProductsDTO productsDTO) {
        return productRepository.updateProduct(id, productsDTO);
    }
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }



}
