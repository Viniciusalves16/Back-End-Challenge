package com.example.account.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record AccountRecord(@NotBlank String agency, @NotNull CustomerOpening customerOpening) {
}
