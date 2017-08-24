package com.bankaccount.domain;

import java.time.LocalDateTime;

public abstract class Operation {
    protected final Amount amount;
    protected final LocalDateTime date;

    protected Operation(Amount amount, LocalDateTime date) {
        this.amount = amount;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operation operation = (Operation) o;

        if (!amount.equals(operation.amount)) return false;
        return date.equals(operation.date);
    }

    @Override
    public int hashCode() {
        int result = amount.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }

    public Amount getAmount() {
        return this.amount;
    }
}
