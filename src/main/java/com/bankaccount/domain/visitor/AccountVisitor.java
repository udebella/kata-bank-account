package com.bankaccount.domain.visitor;

import com.bankaccount.domain.operations.Operation;

public interface AccountVisitor {
    void readOperation(Operation operation);
}
