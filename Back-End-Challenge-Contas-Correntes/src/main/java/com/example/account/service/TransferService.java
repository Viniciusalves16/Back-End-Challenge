package com.example.account.service;

import com.example.account.component.VerifyBalanceFoTransfer;
import com.example.account.dto.TransferRequestDto;
import com.example.account.model.Transfer;
import com.example.account.repository.TransferRepository;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private VerifyBalanceFoTransfer verifyBalanceFoTransfer;

    public ResponseEntity transfer(@Valid TransferRequestDto transferRequestDto) {

        // verificar se a conta existe e se ela  possui saldo para realizar a transferencia
        boolean accountExistsAndActive = transferRepository.accountExistsAndActive(transferRequestDto.getOriginAccount().getAccountNumber(),
                transferRequestDto.getDestinationAccount().getAccountNumber());

        //Verifica se a conta origem possui saldo maior ou igual ao valor de transferencia
        verifyBalanceFoTransfer.verifyBalance(accountExistsAndActive, transferRequestDto);


        return null;
    }
}


// verificar se a conta destimno existe e se esta com o status da conta ativo

// realizar a transferencia dos valores e comunicar os dois sobre a transferencia
// caso nao aconteca a  transferencia deve estornar o valor




