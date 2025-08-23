package com.example.EcommerceApplication.dto;

import jakarta.validation.constraints.*;
public class ProductRequestDTO {
    
    private Long id;
    @NotBlank(message = "Product name is required")
    private String name;
    @NotBlank(message = "Product description is required")
    private String description;
    @NotNull(message = "Product price is required")
    private double price;
    @NotBlank(message = "Product category is required")
    private String category;
    @NotNull(message = "Product stock is required")
    private Integer stock;

    public ProductRequestDTO() {
    }

    public ProductRequestDTO(Long id, String name, String description, double price, String category, Integer stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    
    
}