package com.example.account.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double amount;


    public AccountTransferDto(long id, String agency, Long accountNumber, String cpfCnpj, Double amount) {
        this.id = id;
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }



}
