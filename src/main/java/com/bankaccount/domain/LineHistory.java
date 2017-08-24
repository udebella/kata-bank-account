package com.bankaccount.domain;

import com.bankaccount.domain.operations.Operation;

public class LineHistory {
    private final Operation operation;
    private final Amount balance;

    private LineHistory(Operation operation, Amount balance) {
        this.operation = operation;
        this.balance = balance;
    }

    public static LineHistory of(Operation operation, Amount balance) {
        return new LineHistory(operation, balance.add(operation.getAmount()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LineHistory that = (LineHistory) o;

        if (!operation.equals(that.operation)) return false;
        return balance.equals(that.balance);
    }

    @Override
    public int hashCode() {
        int result = operation.hashCode();
        result = 31 * result + balance.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "LineHistory{" +
                "operation=" + operation +
                ", balance=" + balance +
                '}';
    }

    public Operation getOperation() {
        return operation;
    }
}
