package com.example.account.controller;

import com.example.account.model.Account;
import com.example.account.record.DepositValeuRecord;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositController {

    @PostMapping
    @Transactional
    public ResponseEntity<Account> accountDeposit(@RequestBody @Valid DepositValeuRecord depositValeuRecord) {

    return null;
    }
}
