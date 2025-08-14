package com.example.BankProApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.BankProApplication.domain.Account;
import com.example.BankProApplication.dto.AccountResponseDTO;
import com.example.BankProApplication.mapper.AccountMapper;
import com.example.BankProApplication.service.AccountService;
@RestController
@RequestMapping("/accounts")
public class AccountController {
    
    @Autowired
    private AccountService accountService;

    @Autowired 
    private AccountMapper accountMapper;

    @GetMapping
    public List<AccountResponseDTO> getAllAccounts() {
        List<AccountResponseDTO> list = new ArrayList<>();
        for (Account account: accountService.getAllAccounts()) {
            list.add(accountMapper.toResponse(account));
        }
        return list;
    }

    @PostMapping("/admin")
    public AccountResponseDTO createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return accountMapper.toResponse(createdAccount);
    }

    @GetMapping("/{id}")
    public AccountResponseDTO getAccountById(Long id){
        Account account = accountService.getAccountById(id);
        if (account != null) {
            return accountMapper.toResponse(account);
        }
        return null; 
    }

    @PutMapping("/admin/{id}")
    public AccountResponseDTO updateAccount(@PathVariable Long id, @RequestBody Account account) {
        Account updatedAccount = accountService.updateAccount(id, account);
        if (updatedAccount != null) {
            return accountMapper.toResponse(updatedAccount);
        }
        return null; 
    }

    @DeleteMapping("/admin/{id}")
    public String deleteAccount(@PathVariable Long id) {
        return accountService.deleteAccount(id);
    }

}
