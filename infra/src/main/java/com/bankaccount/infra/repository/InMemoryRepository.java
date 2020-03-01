package com.bankaccount.infra.repository;

import com.bankaccount.domain.operations.Operation;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository implements Repository {
    private List<Operation> operations = new ArrayList<>();

    @Override
    public List<Operation> operations() {
        return operations;
    }

    @Override
    public void add(Operation operation) {
        operations.add(operation);
    }
}
