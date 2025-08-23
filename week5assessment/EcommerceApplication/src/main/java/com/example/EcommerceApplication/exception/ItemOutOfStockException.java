package com.example.EcommerceApplication.exception;


public class ItemOutOfStockException extends RuntimeException{
    public ItemOutOfStockException(String message) {
        super(message);
    }
} 
