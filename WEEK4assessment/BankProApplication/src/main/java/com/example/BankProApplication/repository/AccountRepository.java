package com.example.BankProApplication.repository;
import com.example.BankProApplication.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AccountRepository extends JpaRepository<Account,Long>{
    Account findByAccountNumber(String accountNumber);
} 
