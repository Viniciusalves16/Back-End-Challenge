package com.example.account.record;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CustomerRecord(
        @NotBlank @Pattern(regexp = "^[A-Za-z\\s]+$",
                message = "Name must contain only letters and spaces")
        @Size(min = 1, max = 100) String name,
        @NotBlank String type,
        @NotBlank String cpfCnpj,
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "  1 - Deve conter pelo menos uma letra minúscula." +
                        "    2 -  Deve conter pelo menos uma letra maiúscula." +
                        "    3 - Deve conter pelo menos um dígito.  " +
                        "    4 - Deve conter pelo menos um caractere especial." +
                        "    5 -  Deve ter pelo menos 8 caracteres, podendo ser letras, números ou os caracteres especiais listados.")
        @NotBlank  String password,
        @NotNull @Valid AddressRecord address
) {
}
