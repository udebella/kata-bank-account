package com.bankaccount.domain.operations;

import com.bankaccount.domain.Amount;

import java.time.LocalDateTime;

public class WithdrawOperation extends Operation {

    private WithdrawOperation(Amount amount, LocalDateTime date) {
        super(amount, date);
    }

    @Override
    public String toString() {
        return "WithdrawOperation{" +
                "amount=" + amount +
                '}';
    }

    public static WithdrawOperation of(Amount amount, LocalDateTime date) {
        return new WithdrawOperation(amount.negative(), date);
    }
}
