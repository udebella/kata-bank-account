package com.bankaccount.domain;

public abstract class Operation {
    protected final Amount amount;

    protected Operation(Amount amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operation operation = (Operation) o;

        return amount.equals(operation.amount);
    }

    @Override
    public int hashCode() {
        return amount.hashCode();
    }
}
