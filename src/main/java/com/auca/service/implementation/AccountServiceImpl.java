package com.auca.service.implementation;

import com.auca.dao.AccountDao;
import com.auca.model.Account;
import com.auca.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public Account createAccount(Account account) {
        return accountDao.save(account);
    }

    @Override
    public List<Account> accountList() {
        return accountDao.findAll();
    }

    @Override
    public Account login(String email, String password) {
        return accountDao.findAccountByEmailAndPassword(email, password);
    }
}
