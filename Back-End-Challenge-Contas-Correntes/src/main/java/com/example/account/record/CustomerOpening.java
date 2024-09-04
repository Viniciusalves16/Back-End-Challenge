package com.example.account.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerOpening(@NotBlank long id,  @NotBlank String name, @NotBlank String cpfCnpj, @NotBlank String password) {

}