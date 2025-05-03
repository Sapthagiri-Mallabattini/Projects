package com.saptha.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saptha.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByAccountNumber(String accountNumber);
}
