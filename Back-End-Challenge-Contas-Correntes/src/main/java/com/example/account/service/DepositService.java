package com.example.account.service;

import com.example.account.exception.AccountException;
import com.example.account.model.Account;
import com.example.account.model.Customer;
import com.example.account.record.DepositValeuRecord;
import com.example.account.repository.AccountRepository;
import com.example.account.repository.CustomerRepository;
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

    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<String> depositFunds(DepositValeuRecord depositValeuRecord) {
        Optional<Account> optionalAccount = accountRepository.findByIdAndAccountNumber(depositValeuRecord.id(), depositValeuRecord.accountNumber());

        if (optionalAccount.isPresent()) {
            Account accountDeposit = optionalAccount.get();
            if ("Active".equals(accountDeposit.getStatus())) {
                accountDeposit.setBalance(accountDeposit.getBalance() + depositValeuRecord.value());
                accountRepository.save(accountDeposit);
                return ResponseEntity.status(HttpStatus.OK).body("Deposit made!");
            } else {
                throw new AccountException("Account not Active, Transfer not carried out.");
            }
        } else {
            throw new AccountException("Account not found, please try again!");
        }
    }

}
