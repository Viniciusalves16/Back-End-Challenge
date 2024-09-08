package com.example.account.service;

import com.example.account.exception.AccountException;
import com.example.account.model.Account;
import com.example.account.record.DepositValeuRecord;
import com.example.account.repository.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
public class DepositService {

    @Autowired
    private AccountRepository accountRepository;


    public ResponseEntity depositRule(DepositValeuRecord depositValeuRecord,
                                      Account account,
                                      UriComponentsBuilder uriComponentsBuilder) {


        Account accountDeposit = accountRepository.findById(Long.valueOf(depositValeuRecord.accountNumber())).orElseThrow(() ->
                new AccountException("Account not found, please try again!"));

        if (accountDeposit.getStatus().equals("Active")) {
            accountDeposit.setBalance(accountDeposit.getBalance() + depositValeuRecord.value());
            accountDeposit = accountRepository.save(accountDeposit);
        } else {
            throw new AccountException("Account not Active,Transfer not carried out.");
        }


        return ResponseEntity.status(HttpStatus.OK).body("Deposit made!");

    }
}
