package com.bankaccount.domain.operations;

import com.bankaccount.domain.money.Amount;

import java.time.LocalDate;

public interface OperationReader {
    OperationReader readOperationType(String operationType);

    OperationReader readAmount(Amount amount);

    OperationReader readOperationDate(LocalDate operationDate);
}
