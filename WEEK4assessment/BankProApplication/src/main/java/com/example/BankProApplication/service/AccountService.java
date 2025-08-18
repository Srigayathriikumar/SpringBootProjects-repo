package com.example.BankProApplication.service;
import com.example.BankProApplication.domain.Account;
import com.example.BankProApplication.dto.AccountResponseDTO;
import java.util.List;

public interface AccountService {
    public Account createAccount(Account account);
    public AccountResponseDTO getAccountById(Long id);
    public List<AccountResponseDTO> getAllAccounts();
    public Account updateAccount(Account account);
    public String deleteAccount(Long id);
}
