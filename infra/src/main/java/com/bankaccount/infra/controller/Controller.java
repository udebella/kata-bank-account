package com.bankaccount.infra.controller;

import com.bankaccount.domain.operations.Operation;
import com.bankaccount.infra.repository.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
public class Controller {
    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/versions")
    public ResponseEntity<?> versions() {
        final List<Operation> operations = repository.operations();
        if (!operations.isEmpty()) {
            return ResponseEntity.ok(new Versions(operations.size()));
        }
        return ResponseEntity.notFound().build();
    }
}
