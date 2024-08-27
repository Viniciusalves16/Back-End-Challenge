package com.example.account.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoRecord(@NotNull long cep,
                             @NotBlank String estado,
                             @NotBlank String cidade,
                             @NotBlank String rua,
                             @NotNull long numero) {
}

