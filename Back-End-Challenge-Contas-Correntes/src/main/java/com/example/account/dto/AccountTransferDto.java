package com.example.account.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AccountTransferDto<T> {

    @NotNull
    private long id;

    @NotBlank
    private String agency;

    @NotNull
    private Long accountNumber;



    @NotNull
    private Double amount;

    // Construtores, getters e setters

    public AccountTransferDto(long id, String agency, Long accountNumber, String cpfCnpj, Double amount) {
        this.id = id;
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }



    // Optionally, override equals and hashCode if needed
}
