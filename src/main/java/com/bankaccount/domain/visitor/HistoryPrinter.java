package com.bankaccount.domain.visitor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HistoryPrinter implements AccountVisitor {
    private final Printer printer;
    private String operationType;
    private String operationDate;
    private long amount;
    private long balance;

    public HistoryPrinter(Printer printer) {
        this.printer = printer;
    }

    public void readOperationType(String operationType) {
        this.operationType = operationType;
    }

    public void readOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void readAmount(long amount) {
        this.amount = amount;
    }

    public void readBalance(long balance) {
        this.balance = balance;
    }

    public void completeOperation() {
        this.printer.print(String.format("%s | %s | %s | %s", this.operationType, this.operationDate, amount, balance));
    }
}
