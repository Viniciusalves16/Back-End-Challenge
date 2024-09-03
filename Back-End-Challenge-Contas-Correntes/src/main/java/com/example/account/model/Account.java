package com.example.account.model;

import com.example.account.record.AccountRecord;
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

    @ManyToOne
    private Customer customer;

    public Account(AccountRecord accountRecord) {
        this.agency = accountRecord.agency();
        this.accountNumber = accountRecord.accountNumber();
        this.customer = new Customer(accountRecord.customerRecord());
    }
}
