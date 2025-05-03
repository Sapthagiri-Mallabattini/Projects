package com.saptha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saptha.model.Account;
import com.saptha.service.BankService;

@Controller
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/account")
    public String createAccountPage() {
        return "account";
    }

    @PostMapping("/account")
    public String createAccount(@RequestParam String accountHolder, @RequestParam Double initialDeposit, Model model) {
        try {
            Account account = bankService.createAccount(accountHolder, initialDeposit);
            model.addAttribute("message", "Account created successfully! Your Account Number is: " + account.getAccountNumber());
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "account";
    }


    @GetMapping("/deposit")
    public String depositPage() {
        return "deposit";
    }

    @PostMapping("/deposit")
    public String depositMoney(@RequestParam String accountNumber, @RequestParam Double amount, Model model) {
        try {
            bankService.deposit(accountNumber, amount);
            model.addAttribute("message", "Deposit successful!");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "deposit";
    }

    @GetMapping("/withdraw")
    public String withdrawPage() {
        return "withdraw";
    }

    @PostMapping("/withdraw")
    public String withdrawMoney(@RequestParam String accountNumber, @RequestParam Double amount, Model model) {
        try {
            bankService.withdraw(accountNumber, amount);
            model.addAttribute("message", "Withdrawal successful!");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "withdraw";
    }

    @GetMapping("/transfer")
    public String transferPage() {
        return "transfer";
    }

    @PostMapping("/transfer")
    public String transferMoney(@RequestParam String fromAccount, @RequestParam String toAccount, @RequestParam Double amount, Model model) {
        try {
            bankService.transfer(fromAccount, toAccount, amount);
            model.addAttribute("message", "Transfer successful!");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "transfer";
    }
}
