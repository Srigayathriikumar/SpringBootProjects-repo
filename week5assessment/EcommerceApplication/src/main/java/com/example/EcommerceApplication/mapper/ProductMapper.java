package com.example.EcommerceApplication.mapper;
import com.example.EcommerceApplication.dto.ProductRequestDTO;
import com.example.EcommerceApplication.dto.ProductResponseDTO;
import com.example.EcommerceApplication.domain.Product;
public class ProductMapper {
    
    public static Product toEntity(ProductRequestDTO productRequestDTO){
        Product product = new Product();
        product.setId(productRequestDTO.getId());
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setCategory(productRequestDTO.getCategory());
        product.setStock(productRequestDTO.getStock());
        return product;
    }

    public static ProductResponseDTO toResponseDTO(Product product){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(product.getId());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setCategory(product.getCategory());
        return productResponseDTO;
    }
}
