package com.example.account.service;

import com.example.account.component.SendMessageTransferOkComponent;
import com.example.account.component.VerifyBalanceFoTransfer;
import com.example.account.dto.TransferRequestDto;

import com.example.account.repository.TransferRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private VerifyBalanceFoTransfer verifyBalanceFoTransfer;

    @Autowired
    private SendMessageTransferOkComponent sendMessageTransferOkComponent;

    public ResponseEntity transfer(@Valid TransferRequestDto transferRequestDto) {

        boolean accountExistsAndActive = transferRepository.accountExistsAndActive(transferRequestDto.getOriginAccount().getAccountNumber(), transferRequestDto.getDestinationAccount().getAccountNumber());

        if (!accountExistsAndActive) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Uma ou ambas as contas estão inativas.");
        }

        boolean hasSufficientBalance = verifyBalanceFoTransfer.verifyBalance(accountExistsAndActive, transferRequestDto);
        if (!hasSufficientBalance) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Saldo insuficiente na conta de origem.");
        }
        BigDecimal originBalance = transferRepository.searchBalance(transferRequestDto.getOriginAccount().getAccountNumber());

        transferRepository.updateBalance(transferRequestDto.getOriginAccount().getAccountNumber(), originBalance.subtract(BigDecimal.valueOf(transferRequestDto.getOriginAccount().getAmount())));

        BigDecimal destinationBalance = transferRepository.searchBalance(transferRequestDto.getDestinationAccount().getAccountNumber());

        try {

            transferRepository.updateBalance(transferRequestDto.getDestinationAccount().getAccountNumber(), destinationBalance.add(BigDecimal.valueOf(transferRequestDto.getOriginAccount().getAmount())));

        } catch (Exception e) {
            transferRepository.updateBalance(transferRequestDto.getOriginAccount().getAccountNumber(), originBalance);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Falha na transferência, transação revertida.");

        }
        return ResponseEntity.ok("Transferência realizada com sucesso.");
    }
}






