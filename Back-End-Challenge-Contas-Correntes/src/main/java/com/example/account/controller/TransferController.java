package com.example.account.controller;

import com.example.account.service.TransferService;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping("transfer")
    @Transactional
    public ResponseEntity transferValue() {

        return transferService.transfer();
    }
}
