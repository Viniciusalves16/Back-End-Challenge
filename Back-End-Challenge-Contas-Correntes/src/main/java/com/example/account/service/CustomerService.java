package com.example.account.service;

import com.example.account.model.Customer;
import com.example.account.record.CustomerRecord;
import com.example.account.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public ResponseEntity sendRegistration(Customer customer, UriComponentsBuilder uriComponentsBuilder, CustomerRecord customerRecord) {

        var clienteTemp = customerRepository.save(customer);
        var uri = uriComponentsBuilder.path("/customers").buildAndExpand(clienteTemp.getId()).toUri();
        return ResponseEntity.created(uri).body(new Customer(customerRecord));
    }


    public ResponseEntity deleteRegister(Long id) {
        Optional<Customer> findId = customerRepository.findById(id);
        if (findId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not Found");
        }
        customerRepository.delete(findId.get());
        return ResponseEntity.status(HttpStatus.OK).body("Register deleted sucessfully.");


    }




}
