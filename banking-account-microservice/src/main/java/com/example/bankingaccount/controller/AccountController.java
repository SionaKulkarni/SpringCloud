package com.example.bankingaccount.controller;

import com.example.bankingaccount.model.Account;
import com.example.bankingaccount.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banking/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable int id, @RequestBody Account accountDetails) {
        Optional<Account> updatedAccount = accountService.updateAccount(id, accountDetails);
        return updatedAccount.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
