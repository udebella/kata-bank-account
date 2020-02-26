package com.bankaccount.domain.operations;

import com.bankaccount.domain.money.Balance;
import com.bankaccount.domain.money.Amount;

import java.time.LocalDate;
import java.util.Objects;

public final class Withdrawal implements Operation {
    private final Amount amount;
    private final LocalDate withdrawDate;

    public Withdrawal(Amount amount, LocalDate withdrawDate) {
        this.amount = amount;
        this.withdrawDate = withdrawDate;
    }

    @Override
    public Balance applyOn(Balance balance) {
        return balance.subtract(amount);
    }

    @Override
    public void readOperation(OperationReader operationReader) {
        operationReader.readOperation("Withdrawal", amount, withdrawDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Withdrawal that = (Withdrawal) o;
        return Objects.equals(amount, that.amount) &&
                Objects.equals(withdrawDate, that.withdrawDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, withdrawDate);
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "amount=" + amount +
                ", withdrawDate=" + withdrawDate +
                '}';
    }
}
