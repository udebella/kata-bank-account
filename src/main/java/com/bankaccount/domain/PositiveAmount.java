package com.bankaccount.domain;

import java.util.Objects;

public final class PositiveAmount implements Amount {
    private final long amount;

    private PositiveAmount(long amount) {
        this.amount = amount;
    }

    public static PositiveAmount of(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amounts cannot be negative");
        }
        return new PositiveAmount(amount);
    }

    @Override
    public Balance add(PositiveAmount other) {
        return new Balance(amount + other.amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveAmount amount1 = (PositiveAmount) o;
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
