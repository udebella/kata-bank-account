package com.bankaccount.domain.money;

import java.util.Objects;

public final class Amount {
    final long amount;

    private Amount(long amount) {
        this.amount = amount;
    }

    public static Amount of(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amounts cannot be negative");
        }
        return new Amount(amount);
    }

    public Balance add(Amount other) {
        return Balance.of(amount + other.amount);
    }

    public Balance subtract(Amount other) {
        return Balance.of(amount - other.amount);
    }

    public void readAmount(AmountReader amountReader) {
        amountReader.read(amount);
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
