package com.bankaccount.domain;

import java.util.Objects;

public final class Balance implements Amount {
    private final PositiveAmount amount;
    private final boolean isPositive;

    private Balance(PositiveAmount amount, boolean isPositive) {
        this.amount = amount;
        this.isPositive = isPositive;
    }

    public static Balance of(long amount) {
        final boolean isPositive = amount > 0;
        final PositiveAmount positiveAmount = PositiveAmount.of(Math.abs(amount));
        return new Balance(positiveAmount, isPositive);
    }

    @Override
    public Balance add(PositiveAmount amount) {
        return this.amount.add(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance = (Balance) o;
        return isPositive == balance.isPositive &&
                Objects.equals(amount, balance.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, isPositive);
    }

    @Override
    public String toString() {
        return "Balance{" +
                "balance=" + amount +
                '}';
    }
}
