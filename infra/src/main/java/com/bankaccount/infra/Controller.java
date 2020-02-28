package com.bankaccount.infra;

import com.bankaccount.domain.operations.Operation;
import infra.Repository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class Controller {
    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    public ResponseEntity<?> versions() {
        final List<Operation> operations = repository.operations();
        if (!operations.isEmpty()) {
            return ResponseEntity.ok(new Versions(operations.size()));
        }
        return ResponseEntity.notFound().build();
    }
}
