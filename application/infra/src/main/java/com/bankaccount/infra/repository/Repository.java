package com.bankaccount.infra.repository;

import com.bankaccount.domain.operations.Operation;

import java.util.List;

public interface Repository {
    List<Operation> operations();

    void add(Operation operation);
}
