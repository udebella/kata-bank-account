package com.bankaccount.domain;

import java.time.LocalDate;
import java.util.Objects;

public final class Withdrawal {
    private final PositiveAmount amount;
    private final LocalDate depositDate;

    public Withdrawal(PositiveAmount amount, LocalDate depositDate) {
        this.amount = amount;
        this.depositDate = depositDate;
    }

    public Balance applyOn(Balance balance) {
        return balance.subtract(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Withdrawal that = (Withdrawal) o;
        return Objects.equals(amount, that.amount) &&
                Objects.equals(depositDate, that.depositDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, depositDate);
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "amount=" + amount +
                ", depositDate=" + depositDate +
                '}';
    }
}
