package com.example.account.service;

import com.example.account.model.Customer;
import com.example.account.record.CustomerRecord;
import com.example.account.repository.CustomerRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

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


    public ResponseEntity deleteRegister(Optional<Customer> customer) {
        if (customer.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not Found");
        }
        customerRepository.delete(customer.get());
        return ResponseEntity.status(HttpStatus.OK).body("Register deleted sucessfully");

    }


    public ResponseEntity findAllRegister() {
        var customer = customerRepository.findAll();

        if (customer.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registers not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(customer);

    }


    public ResponseEntity findByRegisterSingle(Long id) {
        var findRegister = customerRepository.findById(id);
        if (findRegister.isEmpty()) {
            throw new EntityNotFoundException("Register Not Found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(findRegister);
    }

    public ResponseEntity updateRegisterCustomer(Long id, CustomerRecord customerRecord) {
        Optional customer = customerRepository.findById(id);

    //todo: avaliar melhor maneira de realizar um updateao
        return null;
    }
}
