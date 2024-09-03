package com.example.account.record;

import jakarta.validation.constraints.NotBlank;


public record AccountRecord(@NotBlank String agency,
                            @NotBlank Double accountNumber,
                            @NotBlank CustomerRecord customerRecord) {
}
