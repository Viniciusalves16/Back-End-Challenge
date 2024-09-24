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


