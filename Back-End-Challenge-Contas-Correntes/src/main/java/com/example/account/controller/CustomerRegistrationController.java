package com.example.account.controller;

import com.example.account.model.Customer;
import com.example.account.record.CustomerRecord;
import com.example.account.service.CustomerService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class CustomerRegistrationController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    @Transactional
    public ResponseEntity cadastroCliente(@RequestBody @Valid CustomerRecord customerRecord,
                                          UriComponentsBuilder uriComponentsBuilder) {

        var clienteTemp = new Customer(customerRecord);
        return customerService.sendRegistration(clienteTemp, uriComponentsBuilder, customerRecord);
    }

    @DeleteMapping("/customers/{customer_id}")
    public ResponseEntity deleteCustomer(@PathVariable(value = "customer_id") Long id) {
        return customerService.deleteRegister(id);
    }

}
