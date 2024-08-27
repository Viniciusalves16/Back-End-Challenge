package com.example.account.record;

import com.example.account.repository.CnpjGroup;
import com.example.account.repository.CpfGroup;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public record ClienteRecord(@NotBlank String nome,
                            @NotBlank String tipo,
                            @NotBlank
                            String cpfCnpj,
                            @NotBlank String senha,
                            @NotNull @Valid EnderecoRecord endereco) {
}

