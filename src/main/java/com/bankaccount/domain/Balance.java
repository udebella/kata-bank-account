package com.bankaccount.domain;

import java.util.Objects;

public final class Balance {
    private final PositiveAmount amount;

    public Balance(long amount) {
        this.amount = PositiveAmount.of(amount);
    }

    public Balance add(PositiveAmount amount) {
        return this.amount.add(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance1 = (Balance) o;
        return Objects.equals(amount, balance1.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Balance{" +
                "balance=" + amount +
                '}';
    }
}
