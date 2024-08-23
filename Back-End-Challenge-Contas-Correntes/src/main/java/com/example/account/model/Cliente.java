package com.example.account.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "Clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String tipo;
    private String cpfCnpj;
    private String senha;

    @Embedded
    private Endereco endereco;
}
