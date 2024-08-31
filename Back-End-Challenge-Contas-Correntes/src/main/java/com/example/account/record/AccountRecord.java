package com.example.account.record;

import jakarta.validation.constraints.NotBlank;


public record AccountRecord(@NotBlank String agency,
                            @NotBlank Double balance,
                            @NotBlank long accountNumber,
                            @NotBlank String status,
                            @NotBlank CustomerRecord customerRecord) {
}
