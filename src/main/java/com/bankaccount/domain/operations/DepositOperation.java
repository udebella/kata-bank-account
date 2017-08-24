package com.bankaccount.domain.operations;

import com.bankaccount.domain.Amount;

import java.time.LocalDateTime;

public class DepositOperation extends Operation {
    private DepositOperation(Amount amount, LocalDateTime date) {
        super(amount, date);
    }

    @Override
    public String toString() {
        return "DepositOperation{" +
                "amount=" + amount +
                '}';
    }

    public static DepositOperation of(Amount amount, LocalDateTime date) {
        return new DepositOperation(amount, date);
    }
}
