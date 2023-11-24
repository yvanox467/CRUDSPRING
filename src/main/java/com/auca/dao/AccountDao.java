package com.auca.dao;

import com.auca.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountDao extends JpaRepository<Account, UUID> {
    Account findAccountByEmailAndPassword(String email, String password);
}
