package com.example.EcommerceApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import com.example.EcommerceApplication.service.ProductService;
import com.example.EcommerceApplication.domain.Product;
import com.example.EcommerceApplication.dto.ProductRequestDTO;
import com.example.EcommerceApplication.dto.ProductResponseDTO;
import com.example.EcommerceApplication.mapper.ProductMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductResponseDTO> response = products.stream()
            .map(ProductMapper::toResponseDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/paged")
    @Operation(summary = "Get paginated products", 
               description = "Retrieve products with pagination and sorting support")
    public ResponseEntity<Page<ProductResponseDTO>> getAllProductsPaged(
            @Parameter(description = "Pagination parameters", 
                      schema = @Schema(implementation = Pageable.class),
                      example = "{\"page\": 0, \"size\": 10, \"sort\": [\"name\"]}") 
            Pageable pageable) {
        Page<Product> products = productService.getAllProducts(pageable);
        Page<ProductResponseDTO> response = products.map(ProductMapper::toResponseDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ProductResponseDTO>> getProductsWithFilters(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) String name) {
        List<Product> products = productService.getProductsWithFilters(category, minPrice, maxPrice, name);
        List<ProductResponseDTO> response = products.stream()
            .map(ProductMapper::toResponseDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductResponseDTO>> getProductsByCategory(@PathVariable String category) {
        List<Product> products = productService.getProductsByCategory(category);
        List<ProductResponseDTO> response = products.stream()
            .map(ProductMapper::toResponseDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/price-range")
    public ResponseEntity<List<ProductResponseDTO>> getProductsByPriceRange(
            @RequestParam Double minPrice, @RequestParam Double maxPrice) {
        List<Product> products = productService.getProductsByPriceRange(minPrice, maxPrice);
        List<ProductResponseDTO> response = products.stream()
            .map(ProductMapper::toResponseDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductResponseDTO>> getProductsByName(@RequestParam String name) {
        List<Product> products = productService.getProductsByName(name);
        List<ProductResponseDTO> response = products.stream()
            .map(ProductMapper::toResponseDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ProductMapper.toResponseDTO(product));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductRequestDTO requestDTO) {
        Product product = ProductMapper.toEntity(requestDTO);
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(ProductMapper.toResponseDTO(savedProduct));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id, @RequestBody ProductRequestDTO requestDTO) {
        Product product = ProductMapper.toEntity(requestDTO);
        product.setId(id);
        Product updatedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(ProductMapper.toResponseDTO(updatedProduct));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}