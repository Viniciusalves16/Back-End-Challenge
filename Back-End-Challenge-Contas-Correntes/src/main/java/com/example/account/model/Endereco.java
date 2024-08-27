package com.example.account.model;

import com.example.account.record.EnderecoRecord;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "enderecos")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long cep;
    private String estado;
    private String cidade;
    private String rua;
    private long numero;

    public Endereco(EnderecoRecord enderecoRecord) {
        this.cep = enderecoRecord.cep();
        this.estado = enderecoRecord.estado();
        this.cidade = enderecoRecord.cidade();
        this.rua = enderecoRecord.rua();
        this.numero = enderecoRecord.numero();
    }
}
