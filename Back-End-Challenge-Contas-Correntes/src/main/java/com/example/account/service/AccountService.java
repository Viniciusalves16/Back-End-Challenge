package com.example.account.service;


import com.example.account.exception.AccountException;
import com.example.account.model.Account;
import com.example.account.model.Customer;
import com.example.account.record.AccountRecord;
import com.example.account.repository.AccountRepository;

import com.example.account.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
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
    private CustomerRepository customerRepository;


    public ResponseEntity createAccountType(AccountRecord accountRecord, UriComponentsBuilder uriComponentsBuilder) throws AccountNotFoundException {

        try {
            // Verifica se o cliente já possui cadastro
            Long customerId = customerRepository.existsByCpfCnpj(accountRecord.customerOpening().cpfCnpj());

            if (customerId == null) {
                throw new AccountException("No customer found for the given CPF/CNPJ.");
            }

            Account newAccount = new Account(accountRecord);
            accountRepository.save(newAccount);
            return ResponseEntity.ok().body(newAccount);

        } catch (EntityNotFoundException e) {
            throw new AccountException("Account opening not carried out, registration must be carried out first", e);
        } catch (AccountException e) {
            return ResponseEntity.badRequest().body(null);
        }

    }
}






