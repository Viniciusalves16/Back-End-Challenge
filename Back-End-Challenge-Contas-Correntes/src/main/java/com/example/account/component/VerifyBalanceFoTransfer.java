package com.example.account.component;

import com.example.account.dto.TransferRequestDto;
import com.example.account.repository.TransferRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class VerifyBalanceFoTransfer {

    @Autowired
    private TransferRepository transferRepository;

    public boolean verifyBalance(boolean accountExistsAndActive, @Valid TransferRequestDto transferRequestDto) {

        if (!accountExistsAndActive) {
        }

        BigDecimal balance = transferRepository.searchBalance(transferRequestDto.getOriginAccount().getAccountNumber());
        if (balance == null) {
        }

        BigDecimal amount = BigDecimal.valueOf(transferRequestDto.getOriginAccount().getAmount());
        return balance.compareTo(amount) >= 0;
    }
}