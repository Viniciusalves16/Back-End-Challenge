package com.example.account.controller;

import com.example.account.record.AccountRecord;
import com.example.account.service.AccountService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.security.auth.login.AccountNotFoundException;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    // Método que realiza a abertura da conta
    @PostMapping("/account")
    @Transactional
    public ResponseEntity accountOpening(@RequestBody @Valid AccountRecord accountRecord, UriComponentsBuilder uriComponentsBuilder) throws AccountNotFoundException {
        return accountService.createAccountType(accountRecord, uriComponentsBuilder);
    }
}
