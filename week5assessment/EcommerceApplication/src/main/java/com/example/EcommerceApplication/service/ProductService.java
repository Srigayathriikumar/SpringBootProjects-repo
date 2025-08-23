package com.example.EcommerceApplication.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.EcommerceApplication.domain.Product;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product saveProduct(Product product);
    void deleteProduct(Long id);
    Page<Product> getAllProducts(Pageable pageable);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice);
    List<Product> getProductsByName(String name);
    List<Product> getProductsWithFilters(String category, Double minPrice, Double maxPrice, String name);
}