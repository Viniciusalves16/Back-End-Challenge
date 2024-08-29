package com.example.account.service;

import com.example.account.model.Customer;
import com.example.account.record.CustomerRecord;
import com.example.account.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public ResponseEntity sendRegistration(Customer customer, UriComponentsBuilder uriComponentsBuilder, CustomerRecord customerRecord) {

        var clienteTemp = customerRepository.save(customer);
        var uri = uriComponentsBuilder.path("/cliente").buildAndExpand(clienteTemp.getId()).toUri();
        return ResponseEntity.created(uri).body(new Customer(customerRecord));
    }
}
