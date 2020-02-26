package com.bankaccount.domain.operations;

import com.bankaccount.domain.money.Amount;

import java.time.LocalDate;

public interface OperationReader {
    void readOperation(String operationType, Amount amount, LocalDate date);
}
