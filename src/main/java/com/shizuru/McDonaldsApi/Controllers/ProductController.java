package com.shizuru.McDonaldsApi.Controllers;
import com.shizuru.McDonaldsApi.dtos.ProductsDTO;
import com.shizuru.McDonaldsApi.models.ProductModel;
import com.shizuru.McDonaldsApi.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductModel> createProduct (@RequestBody @Valid ProductsDTO productsDTO) {
        ProductModel productModel = productService.addProduct(productsDTO);
        return ResponseEntity.status(HttpStatus.OK).body(productModel);
    }
    @GetMapping
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable UUID id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductModel> updateProductById(@PathVariable UUID id,
                                                          @RequestBody @Valid ProductsDTO productsDTO) {
        return ResponseEntity.ok(productService.updateProduct(id, productsDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
