package com.example.account.model;

import com.example.account.controller.ClienteRecord;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "Clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String tipo;
    private String cpfCnpj;
    private String senha;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Conta> conta;

    public Cliente(ClienteRecord clienteRecord) {
        this.nome = clienteRecord.nome();
        this.tipo = clienteRecord.tipo();
        this.cpfCnpj = clienteRecord.cpfCnpj();
        this.senha = clienteRecord.senha();
        this.endereco = new Endereco(clienteRecord.endereco());
    }
}
