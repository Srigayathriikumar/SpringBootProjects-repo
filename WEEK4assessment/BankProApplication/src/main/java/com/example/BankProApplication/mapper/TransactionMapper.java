package com.example.BankProApplication.mapper;

import org.springframework.stereotype.Component;
import com.example.BankProApplication.dto.TransactionResponseDTO;
import com.example.BankProApplication.domain.Transaction;

@Component
public class TransactionMapper {

    public static TransactionResponseDTO toResponse(Transaction transaction) {
        TransactionResponseDTO transactionResponseDTO = new TransactionResponseDTO();
        transactionResponseDTO.setId(transaction.getId());
        transactionResponseDTO.setTransactionDate(transaction.getTransactionDate());
        transactionResponseDTO.setAmount(transaction.getAmount());
        transactionResponseDTO.setTransactionType(transaction.getTransactionType());
        transactionResponseDTO.setAccount(transaction.getAccount());
        return transactionResponseDTO;
    }

    public static Transaction toEntity(TransactionResponseDTO transactionResponseDTO) {
        Transaction transaction = new Transaction();
        transaction.setId(transactionResponseDTO.getId());
        transaction.setTransactionDate(transactionResponseDTO.getTransactionDate());
        transaction.setAmount(transactionResponseDTO.getAmount());
        transaction.setTransactionType(transactionResponseDTO.getTransactionType());
        transaction.setAccount(transactionResponseDTO.getAccount());
        return transaction;
    }
}