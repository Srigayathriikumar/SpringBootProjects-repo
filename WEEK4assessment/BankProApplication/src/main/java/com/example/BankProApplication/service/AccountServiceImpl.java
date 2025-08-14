package com.example.BankProApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.BankProApplication.domain.Account;
import java.util.List;
import java.util.stream.Collectors;
import com.example.BankProApplication.repository.AccountRepository;
import com.example.BankProApplication.dto.*;
@Service
public class AccountServiceImpl implements AccountService {
    
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        accountRepository.save(account);
        return account;
    }
    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }
    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @Override
    public Account updateAccount(Long id,Account account) {
        if (accountRepository.existsById(id)) {
            account.setId(id);
            accountRepository.save(account);
        }
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteAccount(Long id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
        }
        return "Account with ID " + id + " deleted successfully.";
    }

}