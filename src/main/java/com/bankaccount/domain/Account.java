package com.bankaccount.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {
    private final List<Operation> operations = new ArrayList<>();

    private Account(Amount amount, LocalDateTime date) {
        operations.add(CreationOperation.of(amount, date));
    }

    public static Account of(Amount startingAmount, LocalDateTime creationDate) {
        return new Account(startingAmount, creationDate);
    }

    public Amount accountBalance() {
        return operations.stream()
                .map(Operation::getAmount)
                .reduce(Amount.ZERO, Amount::add);
    }

    public void deposit(Amount amount, LocalDateTime date) {
        operations.add(DepositOperation.of(amount, date));
    }

    public void withdraw(Amount amount, LocalDateTime date) {
        operations.add(WithdrawOperation.of(amount, date));
    }

    public List<Operation> consult() {
        return Collections.unmodifiableList(operations);
    }
}
