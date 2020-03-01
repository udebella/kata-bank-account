package com.bankaccount.infra.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HistoryLine {
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
}
