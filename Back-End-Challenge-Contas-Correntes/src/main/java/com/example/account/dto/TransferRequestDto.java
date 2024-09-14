package com.example.account.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransferRequestDto {

    @NotNull
    private AccountTransferDto<Long> originAccount;

    @NotNull
    private AccountTransferDto<Long> destinationAccount;

    public TransferRequestDto() {
    }

    public TransferRequestDto(AccountTransferDto<Long> originAccount, AccountTransferDto<Long> destinationAccount) {
        this.originAccount = originAccount;
        this.destinationAccount = destinationAccount;
    }

}

//exemplo de json
//{
//        "origin": {
//        "id": 123,
//        "agency": "Agency A",
//        "accountNumber": 456789,
//        "cpfCnpj": "12345678900",
//        "amount": 1000.0
//        },
//        "destination": {
//        "id": 456,
//        "agency": "Agency B",
//        "accountNumber": 987654,
//        "cpfCnpj": "09876543211",
//        "amount": 1000.0
//        }
//        }
