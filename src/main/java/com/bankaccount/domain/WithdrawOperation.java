package com.bankaccount.domain;

public class WithdrawOperation extends Operation {
    private WithdrawOperation(Amount amount) {
        super(amount);
    }

    @Override
    public String toString() {
        return "WithdrawOperation{" +
                "amount=" + amount +
                '}';
    }

    public static WithdrawOperation fromAmount(Amount amount) {
        return new WithdrawOperation(amount);
    }
}
