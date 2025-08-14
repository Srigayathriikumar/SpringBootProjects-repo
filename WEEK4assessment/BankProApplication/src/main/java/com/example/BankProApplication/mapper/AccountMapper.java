package com.example.BankProApplication.mapper;

import org.springframework.stereotype.Component;
import com.example.BankProApplication.dto.AccountResponseDTO;
import com.example.BankProApplication.domain.Account;
import com.example.BankProApplication.dto.AccountRequestDTO;

@Component
public class AccountMapper {
    
    public static AccountResponseDTO toResponse(Account account) {
        AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
        accountResponseDTO.setId(account.getId());
        accountResponseDTO.setAccountNumber(account.getAccountNumber());
        accountResponseDTO.setBalance(account.getBalance());
        accountResponseDTO.setCustomer(account.getCustomer());
        return accountResponseDTO;
    }

    public static Account toEntity(AccountRequestDTO accountRequestDTO) {
        Account account = new Account();
        account.setId(accountRequestDTO.getId());
        account.setAccountNumber(accountRequestDTO.getAccountNumber());
        account.setAccountType(accountRequestDTO.getAccountType());
        account.setBalance(accountRequestDTO.getBalance());
        account.setCustomer(accountRequestDTO.getCustomer());
        return account;
    }
}
