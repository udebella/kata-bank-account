package com.bankaccount.domain;

import java.time.LocalDate;
import java.util.Objects;

public final class Deposit implements Operation {
    private final PositiveAmount amount;
    private final LocalDate depositDate;

    public Deposit(PositiveAmount amount, LocalDate depositDate) {
        this.amount = amount;
        this.depositDate = depositDate;
    }

    @Override
    public Balance applyOn(Balance balance) {
        return balance.add(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deposit deposit = (Deposit) o;
        return Objects.equals(amount, deposit.amount) &&
                Objects.equals(depositDate, deposit.depositDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, depositDate);
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "amount=" + amount +
                ", depositDate=" + depositDate +
                '}';
    }
}
