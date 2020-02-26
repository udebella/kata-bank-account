package com.bankaccount.domain.operations;

import com.bankaccount.domain.money.Amount;

import java.time.LocalDate;

public interface OperationReader {
    void readOperation(String operationType, Amount amount, LocalDate date);

    OperationReader readOperationType(String operationType);

    OperationReader readAmount(Amount amount);

    OperationReader readOperationDate(LocalDate operationDate);
}
