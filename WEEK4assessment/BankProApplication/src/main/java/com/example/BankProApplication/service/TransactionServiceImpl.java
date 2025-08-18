package com.example.BankProApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.BankProApplication.repository.TransactionRepository;
import com.example.BankProApplication.repository.AccountRepository;
import com.example.BankProApplication.domain.Transaction;
import com.example.BankProApplication.domain.Account;
import com.example.BankProApplication.dto.TransactionResponseDTO;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

@Service
public class TransactionServiceImpl implements TransactionService{
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Transaction createTransactionbetweenAccounts(Long fromAccountId, Long toAccountId, double amount) {
        Account fromAccount = accountRepository.findById(fromAccountId).orElse(null);
        Account toAccount = accountRepository.findById(toAccountId).orElse(null);
        
        if (fromAccount == null || toAccount == null || fromAccount.getBalance() < amount) {
            return null;
        }
        
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
        
        Transaction debitTransaction = new Transaction(null, new Date(), amount, "Debit", fromAccount);
        Transaction creditTransaction = new Transaction(null, new Date(), amount, "Credit", toAccount);
        
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
        transactionRepository.save(debitTransaction);
        transactionRepository.save(creditTransaction);
        
       return debitTransaction;
    }

    @Override
    public List<Transaction> getAllTransactionHistory() {
        return transactionRepository.findAll().stream()
                .map(transaction -> new Transaction(
                        transaction.getId(),
                        transaction.getTransactionDate(),
                        transaction.getAmount(),
                        transaction.getTransactionType(),
                        transaction.getAccount()))
                .collect(Collectors.toList());
    }
     
    @Override
    public Page<TransactionResponseDTO> getTransactionHistory(Long accountId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return transactionRepository.findByAccountId(accountId, pageable)
                .map(transaction -> new TransactionResponseDTO(transaction.getId(), transaction.getTransactionDate(),
                        transaction.getAmount(), transaction.getTransactionType(), transaction.getAccount()));
    }
}