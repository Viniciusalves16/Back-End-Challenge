package com.example.account.service;


import com.example.account.exception.AccountException;
import com.example.account.exception.CustomerNotFoundException;
import com.example.account.model.Account;
import com.example.account.model.Customer;
import com.example.account.record.AccountRecord;
import com.example.account.repository.AccountRepository;

import com.example.account.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;


    public ResponseEntity createAccountType(AccountRecord accountRecord, Customer customer, UriComponentsBuilder uriComponentsBuilder) throws AccountNotFoundException {

        try {
            // Verifica se o cliente já possui cadastro
            Customer existingCustomer = customerRepository.findById(accountRecord.customerOpening().id()).orElseThrow(() -> new CustomerNotFoundException("Cliente não encontrado com id: " + accountRecord.customerOpening().id()));

            Account newAccount = new Account(accountRecord, existingCustomer);
            accountRepository.save(newAccount);
            return ResponseEntity.ok().body(newAccount);

        } catch (EntityNotFoundException e) {
            throw new AccountException("Account opening not carried out, registration must be carried out first", e);
        } catch (AccountException e) {
            return ResponseEntity.badRequest().body(null);
        }

    }

    public ResponseEntity findAllAccount() {
        List<Account> account = accountRepository.findAll();
        if (account.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Accounts not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(account);
    }
}






