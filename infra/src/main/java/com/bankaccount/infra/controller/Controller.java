package com.bankaccount.infra.controller;

import com.bankaccount.domain.Account;
import com.bankaccount.domain.history.HistoryPrinter;
import com.bankaccount.domain.operations.Operation;
import com.bankaccount.infra.repository.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping
public class Controller {
    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/versions")
    public ResponseEntity<Versions> versions() {
        final List<Operation> operations = repository.operations();
        if (!operations.isEmpty()) {
            return ResponseEntity.ok(new Versions(operations.size()));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<HistoryLine>> history() {
        final Account account = new Account(repository.operations().toArray(new Operation[]{}));
        final ArrayList<HistoryLine> lines = new ArrayList<>();
        final HistoryPrinter historyPrinter = new HistoryPrinter((operationType, operationDate, amount, balance) -> lines.add(new HistoryLine(operationType, operationDate, amount, balance)));

        account.readAccount(historyPrinter);

        return ResponseEntity.ok()
                .body(lines);
    }
}
