package com.example.BankProApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import com.example.BankProApplication.domain.Transaction;
import com.example.BankProApplication.dto.TransactionResponseDTO;
import com.example.BankProApplication.mapper.TransactionMapper;
import com.example.BankProApplication.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionMapper transactionMapper;

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

    @PostMapping("/transfer")
    public TransactionResponseDTO createTransaction(@RequestParam Long fromAccountId, @RequestParam Long toAccountId, @RequestParam double amount) {
        Transaction transaction = transactionService.createTransactionbetweenAccounts(fromAccountId, toAccountId, amount);
        if (transaction != null) {
            return transactionMapper.toResponse(transaction);
        }
        return null; 
    }
}
