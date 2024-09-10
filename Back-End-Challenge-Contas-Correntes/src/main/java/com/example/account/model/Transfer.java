package com.example.account.model;


import jakarta.persistence.*;

@Entity(name = "Transferencia")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Account originAccount;

    @ManyToOne
    private Account destinationAccount;

    private double amount;


}
