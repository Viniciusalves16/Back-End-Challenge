package com.example.account.controller;

import jakarta.validation.constraints.NotBlank;

public record EnderecoRecord(@NotBlank long cep,
                             @NotBlank String estado,
                             @NotBlank String cidade,
                             @NotBlank String rua,
                             @NotBlank long numero) {
}

