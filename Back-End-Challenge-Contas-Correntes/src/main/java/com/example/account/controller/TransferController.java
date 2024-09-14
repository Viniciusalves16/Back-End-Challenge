package com.example.account.controller;

import com.example.account.dto.TransferRequestDto;
import com.example.account.service.TransferService;
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

    @PostMapping("/transfer")
    @Transactional
    public ResponseEntity transferValue(@RequestBody @Valid TransferRequestDto transferRequestDto) {
        return transferService.transfer(transferRequestDto);
    }
}
