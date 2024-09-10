package com.example.account.controller;

import com.example.account.model.Account;
import com.example.account.record.DepositValeuRecord;

import com.example.account.service.DepositService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
public class DepositController {

    @Autowired
    private DepositService depositService;

    // Deposito de valor em conta
    @PostMapping("/deposit")
    @Transactional
    public ResponseEntity<String> accountDeposit(@RequestBody @Valid DepositValeuRecord depositValeuRecord,
                                                 Account account, UriComponentsBuilder uriComponentsBuilder) {


        return depositService.depositFunds(depositValeuRecord);
    }
}
