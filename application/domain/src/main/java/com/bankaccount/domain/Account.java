package com.bankaccount.domain;

import com.bankaccount.domain.history.AccountReader;
import com.bankaccount.domain.money.Amount;
import com.bankaccount.domain.money.Balance;
import com.bankaccount.domain.operations.Deposit;
import com.bankaccount.domain.operations.Operation;
import com.bankaccount.domain.operations.Withdrawal;

import java.time.LocalDate;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Account {
    private final Supplier<LocalDate> dateGenerator;
    private final List<Operation> operations;

    public Account(Operation... operations) {
        this(LocalDate::now, operations);
    }
    public Account(Supplier<LocalDate> dateGenerator, Operation... operations) {
        this.dateGenerator = dateGenerator;
        this.operations = Stream.of(operations).collect(Collectors.toList());
    }

    public Operation deposit(Amount amount) {
        return this.applyOperation(Deposit::new, amount);
    }

    public Operation withdraw(Amount amount) {
        return this.applyOperation(Withdrawal::new, amount);
    }

    private Operation applyOperation(BiFunction<Amount, LocalDate, Operation> operationConstructor, Amount amount) {
        final Operation operation = operationConstructor.apply(amount, dateGenerator.get());
        this.operations.add(operation);
        return operation;
    }

    public Balance balance() {
        return computeBalance((balance, operation) -> operation.applyOn(balance));
    }

    public void readAccount(AccountReader accountReader) {
        computeBalance((currentBalance, operation) -> {
            final Balance nextBalance = operation.applyOn(currentBalance);
            operation.readOperation(accountReader);
            nextBalance.readAmount(accountReader::readBalance);
            accountReader.completeOperation();
            return nextBalance;
        });
    }

    private Balance computeBalance(BiFunction<Balance, Operation, Balance> accumulator) {
        return operations.stream()
                .reduce(Balance.INITIAL,
                        accumulator,
                        (balance, balance2) -> {throw new RuntimeException("Need implementation");});
    }
}
