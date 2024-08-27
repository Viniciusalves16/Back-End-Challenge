package com.example.account.service;

import com.example.account.model.Cliente;
import com.example.account.record.ClienteRecord;
import com.example.account.repository.ClienteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.image.RescaleOp;

import static org.springframework.web.servlet.function.ServerResponse.created;

@Service
public class ClienteService {

    @Autowired
    ClienteRespository clienteRespository;

    public ResponseEntity verificaCadastroUnico(Cliente cliente, UriComponentsBuilder uriComponentsBuilder, ClienteRecord clienteRecord) {

        var clienteTemp = clienteRespository.save(cliente);
        var uri = uriComponentsBuilder.path("/cliente").buildAndExpand(clienteTemp.getId()).toUri();
        return ResponseEntity.created(uri).body(new Cliente(clienteRecord));
    }
}
