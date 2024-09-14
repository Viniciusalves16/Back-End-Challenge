
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

    public Boolean verifyBalance(boolean accountExistsAndActive, @Valid TransferRequestDto transferRequestDto) {

        if (accountExistsAndActive == true) {
            BigDecimal balance = transferRepository.searchBalance(transferRequestDto.getOriginAccount().getAccountNumber());
            if (balance.compareTo(BigDecimal.valueOf(transferRequestDto.getOriginAccount().getAmount())) >= 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false; // Return false if the account doesn't exist or is inactive

        }
    }
}