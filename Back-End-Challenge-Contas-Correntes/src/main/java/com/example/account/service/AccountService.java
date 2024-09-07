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


    public ResponseEntity createAccountType(AccountRecord accountRecord,
                                            UriComponentsBuilder uriComponentsBuilder) throws AccountNotFoundException {

        //Regra de negócio que realiza a abertura da conta
        try {
            Long tempDoc = customerRepository.existsByCpfCnpj(accountRecord.customerOpening().cpfCnpj());// Verifica se o cliente ja possui cadastro
            if (tempDoc == null) {
                throw new AccountException("No customer found for the given CPF/CNPJ.");
            }
            Customer customer = customerRepository.findById(tempDoc) // Busca o id do cliente que é a chave primária para que possa ser aberta a conta vinculada a ele
                    .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
            Account newAccount = new Account(accountRecord, customer);
            accountRepository.save(newAccount);
            return ResponseEntity.ok().body(newAccount);
        } catch (EntityNotFoundException e) {
            throw new AccountException("Account opening not carried out, registration must be carried out first", e);
        }



    }
}






