package com.example.account.service;

import com.example.account.controller.CustomerRegistrationController;
import com.example.account.model.Account;
import com.example.account.record.AccountRecord;
import com.example.account.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRegistrationController controller;

    public ResponseEntity createAccountType(AccountRecord accountRecord) {


        return null;

    }


}
