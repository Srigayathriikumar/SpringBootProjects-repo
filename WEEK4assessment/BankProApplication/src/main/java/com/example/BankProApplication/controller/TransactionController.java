package com.example.BankProApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import com.example.BankProApplication.domain.Transaction;
import com.example.BankProApplication.dto.TransactionResponseDTO;
import com.example.BankProApplication.mapper.TransactionMapper;
import com.example.BankProApplication.service.TransactionService;
import com.example.BankProApplication.repository.AccountRepository;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionMapper transactionMapper;
    
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping
    public List<TransactionResponseDTO> getAllTransactionHistory() {
        List<TransactionResponseDTO> list = new ArrayList<>();
        for (Transaction transaction : transactionService.getAllTransactionHistory()) {
            list.add(transactionMapper.toResponse(transaction));
        }
        return list;
    }

    @GetMapping("/{accountId}")
    public List<TransactionResponseDTO> getTransactionHistory(@PathVariable Long accountId) {
        List<TransactionResponseDTO> list = new ArrayList<>();
        for (Transaction transaction : transactionService.getAllTransactionHistory()) {
            if (transaction.getAccount().getId().equals(accountId) || transaction.getAccount().getId().equals(accountId)) {
                list.add(transactionMapper.toResponse(transaction));
            }
        }
        return list;
    }

    
    
    @PostMapping("/{fromAccountNumber}/{toAccountNumber}/{amount}")
    public Transaction createTransactionByAccountNumber(@PathVariable String fromAccountNumber, @PathVariable String toAccountNumber, @PathVariable double amount) {
        Long fromAccountId = accountRepository.findByAccountNumber(fromAccountNumber).getId();
        Long toAccountId = accountRepository.findByAccountNumber(toAccountNumber).getId();
        return transactionService.createTransactionbetweenAccounts(fromAccountId, toAccountId, amount);
    }
}
