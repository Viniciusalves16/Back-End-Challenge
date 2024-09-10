package com.example.account.controller;

import com.example.account.model.Customer;
import com.example.account.record.CustomerRecord;
import com.example.account.repository.CustomerRepository;
import com.example.account.service.CustomerService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @Autowired
    CustomerRepository customerRepository;

    //Cadastro de clientes
    @PostMapping("/customers")
    @Transactional
    public ResponseEntity cadastroCliente(@RequestBody @Valid CustomerRecord customerRecord,
                                          UriComponentsBuilder uriComponentsBuilder) {
        var clienteTemp = new Customer(customerRecord);
        return customerService.sendRegistration(clienteTemp, uriComponentsBuilder, customerRecord);
    }

    // Lista de clientes
    @GetMapping("/customers")
    public ResponseEntity findAllCustomerRegister() {
        return customerService.findAllRegister();
    }

    // Busca cliente por id
    @GetMapping("/customers/{customer_id}")
    public ResponseEntity findSingleCustomer(@PathVariable(value = "customer_id") @NotBlank Double id) {
        return customerService.findByRegisterSingle(id);

    }
    // Delete de cadastro
    @DeleteMapping("/customers/{customer_id}")
    public ResponseEntity deleteCustomer(@PathVariable(value = "customer_id") Long id) {
        Optional<Customer> product = customerRepository.findById(id);
        return ResponseEntity.ok().body(customerService.deleteRegister(product));
    }


}
