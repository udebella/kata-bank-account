package com.bankaccount.domain.visitor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PrinterVisitor implements AccountVisitor {
    private final Printer printer;
    private String operationType;
    private String operationDate;
    private long amount;
    private long balance;

    public PrinterVisitor(Printer printer) {
        this.printer = printer;
    }

    public void withOperationType(String operationType) {
        this.operationType = operationType;
    }

    public void withOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void withAmount(long amount) {
        this.amount = amount;
    }

    public void withBalance(long balance) {
        this.balance = balance;
    }

    public void build() {
        this.printer.print(String.format("%s | %s | %s | %s", this.operationType, this.operationDate, amount, balance));
    }
}
