package com.bankaccount.domain;

import com.bankaccount.domain.operations.CreationOperation;
import com.bankaccount.domain.operations.DepositOperation;
import com.bankaccount.domain.operations.Operation;
import com.bankaccount.domain.operations.WithdrawOperation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {
    private final List<LineHistory> history = new ArrayList<>();

    private Account(Amount amount, LocalDateTime date) {
        final CreationOperation operation = CreationOperation.of(amount, date);
        final LineHistory lineHistory = LineHistory.of(operation, accountBalance());
        history.add(lineHistory);
    }

    public static Account of(Amount startingAmount, LocalDateTime creationDate) {
        return new Account(startingAmount, creationDate);
    }

    public Amount accountBalance() {
        return history.stream()
                .map(LineHistory::getOperation)
                .map(Operation::getAmount)
                .reduce(Amount.ZERO, Amount::add);
    }

    public void deposit(Amount amount, LocalDateTime date) {
        final DepositOperation operation = DepositOperation.of(amount, date);
        final LineHistory lineHistory = LineHistory.of(operation, accountBalance());
        history.add(lineHistory);
    }

    public void withdraw(Amount amount, LocalDateTime date) {
        final WithdrawOperation operation = WithdrawOperation.of(amount, date);
        final LineHistory lineHistory = LineHistory.of(operation, accountBalance());
        history.add(lineHistory);
    }

    public List<LineHistory> consult() {
        return Collections.unmodifiableList(history);
    }
}
