package com.example.BankProApplication.dto;

import com.example.BankProApplication.domain.Customer;

import jakarta.validation.constraints.*;

public class AccountRequestDTO {
    
    
    private Long id;
    @NotBlank(message = "Account number is mandatory")
    private String accountNumber;
    @Pattern(regexp="^Savings|Current$", message="Account type must be either Savings or Current")
    private String accountType;
    @NotNull(message = "Balance cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Balance must be greater than zero")
    private Double balance;

    public AccountRequestDTO() {
    }

    public AccountRequestDTO(Long id,String accountNumber,String accountType,Double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCustomer'");
    }

    
}
