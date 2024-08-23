package com.example.account.model;

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
    private Long id;
    private long cep;
    private String estado;
    private String cidade;
    private String rua;
    private long numero;

}
