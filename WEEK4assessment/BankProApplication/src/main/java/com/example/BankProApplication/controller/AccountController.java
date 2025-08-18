package com.example.BankProApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.BankProApplication.domain.Account;
import com.example.BankProApplication.dto.AccountResponseDTO;
import com.example.BankProApplication.service.AccountService;
@RestController
@RequestMapping("/accounts")
public class AccountController {
    
    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<AccountResponseDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping("/admin")
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/{id}")
    public AccountResponseDTO getAccountById(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @PutMapping("/admin/{id}")
    public Account updateAccount(@PathVariable Long id, @RequestBody Account account) {
        account.setId(id);
        return accountService.updateAccount(account);
    }

    @DeleteMapping("/admin/{id}")
    public String deleteAccount(@PathVariable Long id) {
        return accountService.deleteAccount(id);
    }

}
