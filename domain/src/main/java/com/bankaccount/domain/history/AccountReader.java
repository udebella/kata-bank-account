package com.bankaccount.domain.history;

import com.bankaccount.domain.operations.OperationReader;

public interface AccountReader extends OperationReader {
    void readBalance(long balance);
    void completeOperation();
}
