package com.bankaccount.domain.visitor;

import com.bankaccount.domain.operations.OperationReader;

public interface AccountReader extends OperationReader {
    void readBalance(long balance);
    void completeOperation();
}
