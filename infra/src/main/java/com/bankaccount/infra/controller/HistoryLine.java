package com.bankaccount.infra.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public final class HistoryLine {
    private final String operationType;
    private final String operationDate;
    private final long amount;
    private final long balance;

    public HistoryLine(String operationType, LocalDate operationDate, long amount, long balance) {
        this.operationType = operationType;
        this.operationDate = operationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.amount = amount;
        this.balance = balance;
    }

    public String getOperationType() {
        return operationType;
    }

    public String getOperationDate() {
        return operationDate;
    }

    public long getAmount() {
        return amount;
    }

    public long getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryLine that = (HistoryLine) o;
        return amount == that.amount &&
                balance == that.balance &&
                Objects.equals(operationType, that.operationType) &&
                Objects.equals(operationDate, that.operationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, operationDate, amount, balance);
    }

    @Override
    public String toString() {
        return "HistoryLine{" +
                "operationType='" + operationType + '\'' +
                ", operationDate='" + operationDate + '\'' +
                ", amount=" + amount +
                ", balance=" + balance +
                '}';
    }
}
