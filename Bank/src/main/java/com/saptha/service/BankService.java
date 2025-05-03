package com.saptha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saptha.model.Account;
import com.saptha.repository.AccountRepository;

@Service
public class BankService {

    @Autowired
    private AccountRepository accountRepository;

    public Account findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found!"));
    }
    
    public Account createAccount(String accountHolder, Double initialDeposit) {
        Account account = new Account();
        account.setAccountHolder(accountHolder);
        account.setBalance(initialDeposit);
        account.setAccountNumber("ACC" + (int)(Math.random() * 1000000));
        return accountRepository.save(account);
    }

    
    public void deposit(String accountNumber, Double amount) {
        Account account = findByAccountNumber(accountNumber);
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }

    public void withdraw(String accountNumber, Double amount) {
        Account account = findByAccountNumber(accountNumber);
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance!");
        }
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, Double amount) {
        Account fromAccount = findByAccountNumber(fromAccountNumber);
        Account toAccount = findByAccountNumber(toAccountNumber);

        if (fromAccount.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance for transfer!");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }
}
