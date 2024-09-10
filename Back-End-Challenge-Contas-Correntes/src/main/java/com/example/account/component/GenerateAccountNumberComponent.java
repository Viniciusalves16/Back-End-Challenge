package com.example.account.component;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GenerateAccountNumberComponent {

    public static Long randomAccountNumber(Long accountNumber) {

        Random random = new Random();
        long number = random.longs(100000000000L, 1000000000000L).findFirst().getAsLong();
        String numberFormat = String.format("%012d", number);

        return Long.valueOf(numberFormat);
    }
}
