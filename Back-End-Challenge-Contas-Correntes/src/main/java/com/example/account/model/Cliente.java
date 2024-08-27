package com.example.account.model;

import com.example.account.component.ValidacaoDocumento;
import com.example.account.record.ClienteRecord;
import com.example.account.repository.CnpjGroup;
import com.example.account.repository.CpfGroup;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.GroupSequence;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import java.util.List;

@Data
@Entity(name = "Clientes")
@GroupSequenceProvider(ValidacaoDocumento.class)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String tipo;
    @CPF(groups = CpfGroup.class)
    @CNPJ(groups = CnpjGroup.class)
    private String cpfCnpj;
    private String senha;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Conta> conta;

    public Cliente(ClienteRecord clienteRecord) {
        this.nome = clienteRecord.nome();
        this.tipo = clienteRecord.tipo();
        this.cpfCnpj = clienteRecord.cpfCnpj();
        this.senha = clienteRecord.senha();
        this.endereco = new Endereco(clienteRecord.endereco());
    }
}
