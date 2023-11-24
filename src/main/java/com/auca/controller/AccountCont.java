package com.auca.controller;

import com.auca.model.Account;
import com.auca.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/auth")
public class AccountCont {
    @Autowired
    AccountService accountService;

    @PostMapping("/createAcc")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        Account createdAccount = accountService.createAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Account> login(@RequestBody String email, String password){
        Account loggedIn = accountService.login(email, password);
        return new ResponseEntity<>(loggedIn, HttpStatus.OK);
    }

    @GetMapping("/findAccounts")
    public ResponseEntity<List<Account>> findAll(){
        List<Account> accountList = accountService.accountList();
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }
}
