package com.auca.service;

import com.auca.model.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    List<Account> accountList();
    Account login(String email, String password);
}
