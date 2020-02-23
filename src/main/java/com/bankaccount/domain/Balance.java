package com.bankaccount.domain;

import java.util.Objects;

public final class Balance {
    private final PositiveAmount balance;

    public Balance(long balance) {
        this.balance = PositiveAmount.of(balance);
    }

    public Balance add(PositiveAmount amount) {
        return balance.add(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance1 = (Balance) o;
        return Objects.equals(balance, balance1.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }

    @Override
    public String toString() {
        return "Balance{" +
                "balance=" + balance +
                '}';
    }
}
