package com.example.account.controller;

import com.example.account.model.Cliente;
import com.example.account.repository.ClienteRespository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
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
    public ResponseEntity cadastroCliente(@Valid @RequestBody ClienteRecord clienteRecord,
                                          Cliente cliente,
                                          UriComponentsBuilder uriComponentsBuilder) {

        BeanUtils.copyProperties(clienteRecord, cliente);

        var uri = uriComponentsBuilder.path("/cliente").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(clienteRespository.save(cliente));
    }

}
