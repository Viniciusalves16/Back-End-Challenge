package com.example.account.controller;

import com.example.account.dto.TransferRequestDto;
import com.example.account.service.TransferService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.transaction.Transactional;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    @Autowired
    private TransferService transferService;
    @Operation(description = "Realiza a transferencia entre contas ")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Transferência realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Uma ou ambas as contas estão inativas."),
            @ApiResponse(responseCode = "404", description = "Nenhuma conta encontrada")
    })
    @PostMapping("/transfer")
    @Transactional
    public ResponseEntity transferValue(@RequestBody @Valid TransferRequestDto transferRequestDto) {
        return transferService.transfer(transferRequestDto);
    }
}
