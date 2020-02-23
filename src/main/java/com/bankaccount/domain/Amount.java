package com.bankaccount.domain;

import java.util.Objects;

public final class Amount {
    private final long amount;

    public Amount(long amount) {
        this.amount = amount;
    }

    public static Amount of(long amount) {
        throw new IllegalArgumentException("Amounts cannot be negative");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount1 = (Amount) o;
        return amount == amount1.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Amount{" +
                "amount=" + amount +
                '}';
    }
}
