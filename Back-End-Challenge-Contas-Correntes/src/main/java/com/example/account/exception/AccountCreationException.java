package com.example.account.exception;

import lombok.Data;

@Data
public class AccountCreationException extends RuntimeException {

    public AccountCreationException(String message) {
        super(message);
    }

    public AccountCreationException(String message, Throwable cause) {
        super(message, cause);
    }

}
