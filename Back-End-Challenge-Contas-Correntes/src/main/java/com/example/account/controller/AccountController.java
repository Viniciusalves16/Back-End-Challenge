package com.example.account.controller;

import com.example.account.model.Account;
import com.example.account.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    public ResponseEntity accountOpening(@RequestBody @Valid AccountRecord accountRecord) {

        var accountTemp = new Account(accountRecord);
        this.accountService.createAccountType(accountRecord);

        return null;
    }
}
