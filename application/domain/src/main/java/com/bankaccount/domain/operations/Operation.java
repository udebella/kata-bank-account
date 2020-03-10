package com.bankaccount.domain.operations;

import com.bankaccount.domain.money.Balance;

public interface Operation {
    Balance applyOn(Balance balance);

    void readOperation(OperationReader operationReader);
}
