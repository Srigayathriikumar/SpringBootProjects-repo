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
        return accountRepository.save(account);
    }
    
    @Override
    public AccountResponseDTO getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElse(null);
        if (account == null) {
            return null;
        }
        return new AccountResponseDTO(account.getId(), account.getAccountNumber(), 
                                    account.getAccountType(), account.getBalance(), account.getCustomer());
    }
    
    @Override
    public List<AccountResponseDTO> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(account -> new AccountResponseDTO(account.getId(), account.getAccountNumber(),
                        account.getAccountType(), account.getBalance(), account.getCustomer()))
                .collect(Collectors.toList());
    }

    @Override
    public Account updateAccount(Account account) {
        if (accountRepository.existsById(account.getId())) {
            accountRepository.save(account);
        }
        return account;
    }

    @Override
    public String deleteAccount(Long id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
        }
        return "Account deleted successfully";
    }
}