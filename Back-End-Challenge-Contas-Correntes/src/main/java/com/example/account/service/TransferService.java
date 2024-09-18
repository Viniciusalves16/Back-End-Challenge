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

        // verificar se a conta existe e se ela  possui saldo para realizar a transferencia
        boolean accountExistsAndActive = transferRepository.accountExistsAndActive(transferRequestDto.getOriginAccount().getAccountNumber(),
                transferRequestDto.getDestinationAccount().getAccountNumber());

        // verifica se a conta é existente
        if (!accountExistsAndActive) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Uma ou ambas as contas estão inativas.");
        }

        // verifica se o saldo da conta origem é aceito
        boolean hasSufficientBalance = verifyBalanceFoTransfer.verifyBalance(accountExistsAndActive, transferRequestDto);
        if (!hasSufficientBalance) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Saldo insuficiente na conta de origem.");
        }
        //busca o saldo da conta origem
        BigDecimal originBalance = transferRepository.searchBalance(transferRequestDto.getOriginAccount().getAccountNumber());
        //realiza o update do valor na conta origem
        transferRepository.updateBalance(transferRequestDto.getOriginAccount().getAccountNumber(), originBalance.subtract(BigDecimal.valueOf(transferRequestDto.getOriginAccount().getAmount())));


        //busca o saldo da conta destino
        BigDecimal destinationBalance = transferRepository.searchBalance(transferRequestDto.getDestinationAccount().getAccountNumber());

        try {
            //realiza o update do valor na conta destino
            transferRepository.updateBalance(transferRequestDto.getDestinationAccount().getAccountNumber(), destinationBalance.add(BigDecimal.valueOf(transferRequestDto.getOriginAccount().getAmount())));

        } catch (Exception e) {
            // Reverter a atualização na conta de origem
            transferRepository.updateBalance(transferRequestDto.getOriginAccount().getAccountNumber(), originBalance);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Falha na transferência, transação revertida.");

        }
        return ResponseEntity.ok("Transferência realizada com sucesso.");
    }
}






