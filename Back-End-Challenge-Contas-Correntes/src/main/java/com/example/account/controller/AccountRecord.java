package com.example.account.controller;

import com.example.account.record.CustomerRecord;
import jakarta.validation.constraints.NotBlank;


public record AccountRecord(@NotBlank String agency,
                            @NotBlank Double balance,
                            @NotBlank
                            @NotBlank String status,
                            @NotBlank CustomerRecord customerRecord) {
}
