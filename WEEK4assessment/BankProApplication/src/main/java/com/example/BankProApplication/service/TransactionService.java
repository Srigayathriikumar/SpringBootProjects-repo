package com.example.BankProApplication.service;
import com.example.BankProApplication.domain.Transaction;
import com.example.BankProApplication.dto.TransactionResponseDTO;

import java.util.List;

import org.springframework.data.domain.Page;

public interface TransactionService {
    public Transaction createTransactionbetweenAccounts(Long fromAccountId, Long toAccountId, double amount);
    public List<Transaction> getAllTransactionHistory();
    Page<TransactionResponseDTO> getTransactionHistory(Long accountId, int page, int size);

}
