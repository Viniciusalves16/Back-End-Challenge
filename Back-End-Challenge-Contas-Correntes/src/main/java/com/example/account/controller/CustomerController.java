package com.example.account.controller;


import com.example.account.model.Customer;
import com.example.account.record.CustomerRecord;
import com.example.account.repository.CustomerRepository;
import com.example.account.service.CustomerService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    private CustomerService customerService;

    @PostMapping("/cliente")
    @Transactional
    public ResponseEntity cadastroCliente(@RequestBody @Valid CustomerRecord customerRecord,
                                          UriComponentsBuilder uriComponentsBuilder) {
        var clienteTemp = new Customer(customerRecord);

        return customerService.sendRegistration(clienteTemp, uriComponentsBuilder, customerRecord);
    }

}