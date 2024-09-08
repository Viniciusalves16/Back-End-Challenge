package com.example.account.model;

import com.example.account.record.AccountRecord;
import com.example.account.record.DepositValeuRecord;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "Contas")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer accountNumber;

    @Column(unique = true)
    private String agency;
    private double balance;
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Account(AccountRecord accountRecord) {
        this.agency = accountRecord.agency();
        this.customer = customer;
        this.status = "Active";
    }

    public Account(DepositValeuRecord depositValeuRecord) {
        this.balance = depositValeuRecord.value();

    }

    public Account() {
    }

}
