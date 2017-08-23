package com.bankaccount.domain;

public class CreationOperation extends Operation {
    private CreationOperation(Amount amount) {
        super(amount);
    }

    @Override
    public String toString() {
        return "CreationOperation{" +
                "amount=" + amount +
                '}';
    }

    public static CreationOperation fromAmount(Amount amount) {
        return new CreationOperation(amount);
    }
}
