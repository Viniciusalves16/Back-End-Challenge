package com.example.account.model;

import com.example.account.record.AccountRecord;
import jakarta.persistence.*;
import lombok.Data;

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

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    public Account(AccountRecord accountRecord, Long docTemp) {
        this.agency = accountRecord.agency();
        this.customer = new Customer(accountRecord.customerOpening(), docTemp);
        this.status = "Active";
    }
}
