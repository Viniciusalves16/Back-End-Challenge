package com.example.account.model;


import com.example.account.component.GenerateAccountNumberComponent;
import com.example.account.record.AccountRecord;
import com.example.account.record.DepositValeuRecord;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Random;

@Data
@Entity(name = "Contas")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id;

    @Column(unique = true)
    private Long accountNumber;

    private String agency;
    private double balance;
    private String status;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Account(AccountRecord accountRecord, Customer existingCustomer) {

        this.agency = accountRecord.agency();
        this.accountNumber = GenerateAccountNumberComponent.randomAccountNumber(1l);
        this.customer = existingCustomer;
        this.status = "Active";
    }

    public Account(DepositValeuRecord depositValeuRecord) {
        this.balance = depositValeuRecord.value();

    }

    public Account() {
    }

}
