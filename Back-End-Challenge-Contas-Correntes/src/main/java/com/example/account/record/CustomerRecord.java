package com.example.account.record;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerRecord(@NotBlank String name,
                             @NotBlank String type,
                             @NotBlank
                            String cpfCnpj,
                             @NotBlank String password,
                             @NotNull @Valid AddressRecord address) {
}

