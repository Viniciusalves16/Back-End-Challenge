package com.example.account.record;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CustomerRecord(
        @NotBlank @Pattern(regexp = "^[A-Za-z\\s]+$",
                message = "Name must contain only letters and spaces")
        @Size(min = 1, max = 100) String applicantName,
        @NotBlank String type,
        @NotBlank String cpfCnpj,
        @NotBlank String password,
        @NotNull @Valid AddressRecord address
) {
}
