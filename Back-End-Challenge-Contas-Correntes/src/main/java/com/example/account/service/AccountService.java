package com.example.account.service;


import com.example.account.component.CheckIdentityComponent;
import com.example.account.model.Account;
import com.example.account.record.AccountRecord;
import com.example.account.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import javax.security.auth.login.AccountNotFoundException;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    CheckIdentityComponent component;

    public ResponseEntity createAccountType(AccountRecord accountRecord, UriComponentsBuilder uriComponentsBuilder) throws AccountNotFoundException {
        Long docTemp = component.verifyIdentity(accountRecord.customerOpening().cpfCnpj());
        if (!docTemp.equals(null)) {
            var uri = uriComponentsBuilder.path("/account").buildAndExpand(accountRecord.customerOpening().cpfCnpj()).toUri();
            var account = new Account(accountRecord,docTemp);
            return ResponseEntity.created(uri).body(accountRepository.save(account));
        } else {
            throw new AccountNotFoundException("No account found for CPF/CNPJ, " + "It is mandatory to create your registration first : " + accountRecord.customerOpening().cpfCnpj());
        }


    }


}
