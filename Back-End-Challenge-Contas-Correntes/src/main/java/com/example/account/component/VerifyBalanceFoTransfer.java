
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
            return false; // Se a conta não existe ou está inativa
        }

        // Verificar saldo da conta de origem
        BigDecimal balance = transferRepository.searchBalance(transferRequestDto.getOriginAccount().getAccountNumber());
        if (balance == null) {
            return false; // Conta não encontrada
        }

        // Verificar se o saldo é suficiente para a transferência
        BigDecimal amount = BigDecimal.valueOf(transferRequestDto.getOriginAccount().getAmount());
        return balance.compareTo(amount) >= 0;
    }
}