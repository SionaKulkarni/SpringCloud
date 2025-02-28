package com.example.bankingaccount.service;

import com.example.bankingaccount.model.Account;
import com.example.bankingaccount.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> updateAccount(int id, Account accountDetails) {
        return accountRepository.findById(id).map(account -> {
            account.setAccountHolder(accountDetails.getAccountHolder());
            account.setBalance(accountDetails.getBalance());
            return accountRepository.save(account);
        });
    }
}
