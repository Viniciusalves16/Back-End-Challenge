package com.example.account.controller;

import com.example.account.model.Account;
import com.example.account.record.AccountRecord;
import com.example.account.service.AccountService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account")
    @Transactional
    public ResponseEntity accountOpening(@RequestBody @Valid AccountRecord accountRecord) {
        accountService.createAccountType(accountRecord);


        return null;
    }
}
