package com.example.account.service;

import com.example.account.controller.AccountRecord;
import com.example.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public ResponseEntity createAccountType(AccountRecord accountRecord) {

        return null;
    }


}
