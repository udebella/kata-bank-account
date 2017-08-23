package com.bankaccount.domain;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private Amount amount;
    private List<Operation> operations = new ArrayList<>();

    private Account(Amount amount) {
        operations.add(CreationOperation.fromAmount(amount));
        this.amount = amount;
    }

    public static Account fromAmount(Amount startingAmount) {
        return new Account(startingAmount);
    }

    public Amount accountBalance() {
        return amount;
    }

    public void deposit(Amount amount) {
        operations.add(DepositOperation.fromAmount(amount));
        this.amount = this.amount.add(amount);
    }

    public void withdraw(Amount amount) {
        this.amount = this.amount.substract(amount);
    }

    public List<Operation> consult() {
        return new ArrayList<>(operations);
    }
}
