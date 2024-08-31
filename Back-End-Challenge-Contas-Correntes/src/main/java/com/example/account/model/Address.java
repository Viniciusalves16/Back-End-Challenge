package com.example.account.model;

import com.example.account.record.AddressRecord;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "enderecos")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long cep;
    private String estado;
    private String cidade;
    private String rua;
    private long numero;

    @OneToOne
    private Customer customer;

    public Address(AddressRecord addressRecord) {
        this.cep = addressRecord.zipCode();
        this.estado = addressRecord.state();
        this.cidade = addressRecord.city();
        this.rua = addressRecord.road();
        this.numero = addressRecord.number();
    }
}
