package com.example.account.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteRecord(@NotBlank String nome,
                            @NotBlank String tipo,
                            @NotBlank String cpfCnpj,
                            @NotBlank String senha,
                            @NotNull @Valid EnderecoRecord enderecoRecord) {
}

