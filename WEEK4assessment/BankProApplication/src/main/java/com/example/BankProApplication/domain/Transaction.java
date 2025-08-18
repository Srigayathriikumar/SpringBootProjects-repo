package com.example.BankProApplication.domain;
import java.util.Date;
import java.util.List;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "transactions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Transaction {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Date transactionDate;
    private Double amount;
    private String transactionType; 
   

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
   

    public Transaction() {
    }
    public Transaction(Long id, Date transactionDate, Double amount, String transactionType, Account account) {
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
