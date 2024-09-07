package com.example.account.record;

import jakarta.validation.constraints.*;
import jdk.jfr.Name;

public record DepositValeuRecord(@NotNull @Min(1) Integer value,
                                 String agency,
                                 Integer accountNumber,
                                 @NotBlank @Pattern(regexp = "^[A-Za-z\\s]+$",
                                         message = "Name must contain only letters and spaces")
                                 @Size(min = 1, max = 100) String applicantName) {
}

