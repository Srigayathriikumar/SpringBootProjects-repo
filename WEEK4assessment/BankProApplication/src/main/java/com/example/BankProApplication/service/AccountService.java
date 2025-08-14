package com.example.BankProApplication.service;
import com.example.BankProApplication.domain.Account;

import java.util.List;
public interface AccountService {
    public Account createAccount(Account account);
    public Account getAccountById(Long id);
    public List<Account> getAllAccounts();
    public Account updateAccount(Long id,Account account);
    public String deleteAccount(Long id);

}
