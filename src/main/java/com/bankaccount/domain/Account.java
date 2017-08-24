package com.bankaccount.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {
    private final List<Operation> operations = new ArrayList<>();

    private Account(Amount amount) {
        operations.add(CreationOperation.fromAmount(amount));
    }

    public static Account fromAmount(Amount startingAmount) {
        return new Account(startingAmount);
    }

    public Amount accountBalance() {
        return operations.stream()
                .map(Operation::getAmount)
                .reduce(Amount.ZERO, Amount::add);
    }

    public void deposit(Amount amount) {
        operations.add(DepositOperation.fromAmount(amount));
    }

    public void withdraw(Amount amount) {
        operations.add(WithdrawOperation.fromAmount(amount));
    }

    public List<Operation> consult() {
        return Collections.unmodifiableList(operations);
    }
}
