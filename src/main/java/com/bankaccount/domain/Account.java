package com.bankaccount.domain;

import java.util.ArrayList;
import java.util.Collections;
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
        operations.add(WithdrawOperation.fromAmount(amount.negative()));
        this.amount = this.amount.add(amount.negative());
    }

    public List<Operation> consult() {
        return Collections.unmodifiableList(operations);
    }
}
