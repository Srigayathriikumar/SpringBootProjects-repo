package com.example.EcommerceApplication.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.example.EcommerceApplication.repository.ProductRepository;
import com.example.EcommerceApplication.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveProduct(){
        Product product = new Product();
        product.setName("Laptop");
        product.setPrice(999.99);
        when(productRepository.save(product)).thenReturn(product);
        Product savedProduct = productService.saveProduct(product);
        assertNotNull(savedProduct);
        assertEquals("Laptop", savedProduct.getName());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void testGetAllProducts(){
        Product product1 = new Product(); product1.setName("Laptop");
        Product product2 = new Product(); product2.setName("Phone");
        when(productRepository.findAll()).thenReturn(List.of(product1, product2));
        List<Product> products = productService.getAllProducts();
        assertEquals(2, products.size());
        assertEquals("Laptop", products.get(0).getName());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testGetProductById(){
        Product product = new Product();
        product.setId(1L);
        product.setName("Laptop");
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Product foundProduct = productService.getProductById(1L);
        assertNotNull(foundProduct);
        assertEquals("Laptop", foundProduct.getName());
        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    void testGetAllProductsPaged(){
        Product product = new Product(); product.setName("Laptop");
        Page<Product> page = new PageImpl<>(List.of(product));
        when(productRepository.findAll(any(Pageable.class))).thenReturn(page);
        Page<Product> result = productService.getAllProducts(Pageable.unpaged());
        assertEquals(1, result.getContent().size());
        verify(productRepository, times(1)).findAll(any(Pageable.class));
    }

    @Test
    void testGetProductsByCategory(){
        Product product = new Product(); product.setCategory("Electronics");
        when(productRepository.findByCategory("Electronics")).thenReturn(List.of(product));
        List<Product> products = productService.getProductsByCategory("Electronics");
        assertEquals(1, products.size());
        verify(productRepository, times(1)).findByCategory("Electronics");
    }

    @Test
    void testGetProductsByPriceRange(){
        Product product = new Product(); product.setPrice(500.0);
        when(productRepository.findByPriceBetween(100.0, 1000.0)).thenReturn(List.of(product));
        List<Product> products = productService.getProductsByPriceRange(100.0, 1000.0);
        assertEquals(1, products.size());
        verify(productRepository, times(1)).findByPriceBetween(100.0, 1000.0);
    }

    @Test
    void testDeleteProduct(){
        productService.deleteProduct(1L);
        verify(productRepository, times(1)).deleteById(1L);
    }
}