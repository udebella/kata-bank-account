package com.bankaccount.domain;

public class DepositOperation extends Operation {
    private DepositOperation(Amount amount) {
        super(amount);
    }

    @Override
    public String toString() {
        return "DepositOperation{" +
                "amount=" + amount +
                '}';
    }

    public static DepositOperation fromAmount(Amount amount) {
        return new DepositOperation(amount);
    }
}
