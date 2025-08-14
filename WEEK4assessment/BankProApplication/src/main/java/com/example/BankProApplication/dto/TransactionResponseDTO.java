package com.example.BankProApplication.dto;
import com.example.BankProApplication.domain.Account;
import java.util.Date;

public class TransactionResponseDTO {
     private Long id;
    private Date transactionDate;
    private Double amount;
    private String transactionType; 
    private Account account;

    public TransactionResponseDTO() {
    }
    public TransactionResponseDTO(Long id, Date transactionDate, Double amount, String transactionType, Account account) {
        this.id = id;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.transactionType = transactionType;
        this.account = account;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public String getTransactionType() {
        return transactionType;
    }
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }

    
}
