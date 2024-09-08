package com.example.account.model;

import com.example.account.component.GenerateAccountNumber;
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
    private Integer accountNumber;

    private String agency;
    private double balance;
    private String status;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Account(AccountRecord accountRecord) {

        this.agency = accountRecord.agency();
        this.accountNumber = GenerateAccountNumber.generateValueAccountNumber(1);
        this.customer = customer;
        this.status = "Active";
    }

    public Account(DepositValeuRecord depositValeuRecord) {
        this.balance = depositValeuRecord.value();

    }

    public Account() {
    }

}
