package com.example.account.model;

import com.example.account.controller.AccountRecord;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "Contas")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Double accountNumber;

    @Column(unique = true)
    private String agency;

    private double balance;
    private String status;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Customer> customer;

    public Account(AccountRecord accountRecord) {
        this.agency = accountRecord.agency();
        this.balance = accountRecord.balance();
        this.status = accountRecord.status();
        this.customer = (List<Customer>) new Customer(accountRecord.customerRecord());

    }
}
