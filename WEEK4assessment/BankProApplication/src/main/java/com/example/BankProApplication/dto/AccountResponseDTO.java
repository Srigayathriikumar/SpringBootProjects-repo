package com.example.BankProApplication.dto;

import com.example.BankProApplication.domain.Customer;

public class AccountResponseDTO {
    private Long id;
    private String accountNumber;
    private String accountType;
    private Double balance;
    private Customer customer;
    public AccountResponseDTO() {
    }
    public AccountResponseDTO(Long id, String accountNumber, String accountType, Double balance, Customer customer) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.customer = customer;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    
    
}
