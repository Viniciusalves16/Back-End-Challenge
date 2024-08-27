package com.example.account.controller;

import com.example.account.model.Cliente;
import com.example.account.record.ClienteRecord;
import com.example.account.repository.ClienteRespository;
import com.example.account.service.ClienteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ClienteCadastroController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente")
    @Transactional
    public ResponseEntity cadastroCliente(@RequestBody @Valid ClienteRecord clienteRecord, UriComponentsBuilder uriComponentsBuilder) {

        var clienteTemp = new Cliente(clienteRecord);
        return clienteService.verificaCadastroUnico(clienteTemp, uriComponentsBuilder, clienteRecord);
    }

}
