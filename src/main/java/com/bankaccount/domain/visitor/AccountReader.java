package com.bankaccount.domain.visitor;

import com.bankaccount.domain.operations.Operation;

public interface AccountReader {
    void readOperation(Operation operation);
}
