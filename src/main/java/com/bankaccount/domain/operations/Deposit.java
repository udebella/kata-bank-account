package com.bankaccount.domain.operations;

import com.bankaccount.domain.money.Balance;
import com.bankaccount.domain.money.Amount;

import java.time.LocalDate;
import java.util.Objects;

public final class Deposit implements Operation {
    private final Amount amount;
    private final LocalDate depositDate;

    public Deposit(Amount amount, LocalDate depositDate) {
        this.amount = amount;
        this.depositDate = depositDate;
    }

    @Override
    public Balance applyOn(Balance balance) {
        return balance.add(amount);
    }

    @Override
    public void readOperation(OperationReader operationReader) {
        operationReader.readOperation("Deposit", amount, depositDate);
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
