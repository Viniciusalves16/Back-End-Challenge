package com.example.account.controller;

import com.example.account.model.Customer;
import com.example.account.record.AccountRecord;
import com.example.account.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.security.auth.login.AccountNotFoundException;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;
    @PostMapping("/account")
    @Transactional
    public ResponseEntity accountOpening(@RequestBody @Valid AccountRecord accountRecord, Customer customer,  UriComponentsBuilder uriComponentsBuilder) throws AccountNotFoundException {
        return accountService.createAccountType(accountRecord, customer, uriComponentsBuilder);
    }

    @GetMapping("account")
    public ResponseEntity findAllAccount() {
        return accountService.findAllAccount();
    }



}
