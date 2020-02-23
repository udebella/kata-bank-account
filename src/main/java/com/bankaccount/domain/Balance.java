package com.bankaccount.domain;

import java.util.Objects;

public final class Balance implements Amount {
    private final PositiveAmount amount;
    private final boolean isPositive;

    public Balance(long amount) {
        this.isPositive = amount > 0;
        this.amount = PositiveAmount.of(this.isPositive ? amount : -amount);
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
