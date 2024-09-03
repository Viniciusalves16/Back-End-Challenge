package com.example.account.model;

import com.example.account.component.ValidateDocumentTypeComponent;
import com.example.account.record.CustomerRecord;
import com.example.account.repository.CnpjGroup;
import com.example.account.repository.CpfGroup;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Clientes")
@GroupSequenceProvider(ValidateDocumentTypeComponent.class)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    private String name;
    private String type;

    @CPF(groups = CpfGroup.class)
    @CNPJ(groups = CnpjGroup.class)
    @Column(unique = true)
    private String cpfCnpj;

    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Account> account;

    public Customer(CustomerRecord customerRecord) {
        this.name = customerRecord.name();
        this.type = customerRecord.type();
        this.cpfCnpj = customerRecord.cpfCnpj();
        this.password = customerRecord.password();
        this.address = new Address(customerRecord.address());
    }

}
