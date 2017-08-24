package com.bankaccount.domain.operations;

import com.bankaccount.domain.Amount;

import java.time.LocalDateTime;

public class CreationOperation extends Operation {
    private CreationOperation(Amount amount, LocalDateTime date) {
        super(amount, date);
    }

    @Override
    public String toString() {
        return "CreationOperation{" +
                "amount=" + amount +
                '}';
    }

    public static CreationOperation of(Amount amount, LocalDateTime date) {
        return new CreationOperation(amount, date);
    }
}
