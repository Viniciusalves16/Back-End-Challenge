package com.example.account.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddressRecord(@NotNull long zipCode,
                            @NotBlank String state,
                            @NotBlank String city,
                            @NotBlank String road,
                            @NotNull long number) {
}

