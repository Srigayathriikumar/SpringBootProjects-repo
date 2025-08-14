package com.example.BankProApplication.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;
    private String accountType;
    private Double balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> transactions;

    public Account() {}

    public Account(Long id, String accountNumber, String accountType, Double balance, Customer customer) {
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
    public List<Transaction> getTransactions() {
         return transactions; 
        }
    public void setTransactions(List<Transaction> transactions) {
         this.transactions = transactions; 
        }
}