package com.example.account.controller;

import com.example.account.model.Cliente;
import com.example.account.repository.ClienteRespository;
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
    private ClienteRespository clienteRespository;

    @PostMapping("/cliente")
    @Transactional
    public ResponseEntity cadastroCliente( @RequestBody @Valid ClienteRecord clienteRecord,
                                          UriComponentsBuilder uriComponentsBuilder) {

        var clienteTemp = new Cliente(clienteRecord);

        var uri = uriComponentsBuilder.path("/cliente").buildAndExpand(clienteTemp.getId()).toUri();
        return ResponseEntity.created(uri).body(clienteRespository.save(clienteTemp));
    }

}
