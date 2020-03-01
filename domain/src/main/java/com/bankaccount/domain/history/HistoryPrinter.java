package com.bankaccount.domain.history;

import com.bankaccount.domain.money.Amount;
import com.bankaccount.domain.operations.OperationReader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HistoryPrinter implements AccountReader {
    private final Printer printer;
    private String operationType;
    private LocalDate operationDate;
    private long amount;
    private long balance;

    public HistoryPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public OperationReader readOperationType(String operationType) {
        this.operationType = operationType;
        return this;
    }

    @Override
    public OperationReader readOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate;
        return this;
    }

    @Override
    public OperationReader readAmount(Amount amount) {
        amount.readAmount(this::readAmount);
        return this;
    }

    public void readAmount(long amount) {
        this.amount = amount;
    }

    public void readBalance(long balance) {
        this.balance = balance;
    }

    public void completeOperation() {
        this.printer.print(String.format("%s | %s | %s | %s", this.operationType, operationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), amount, balance));
        this.printer.print(this.operationType, this.operationDate, amount, balance);
    }
}
