package com.bankaccount.infra;

import infra.Repository;
import org.springframework.http.ResponseEntity;

public class Controller {
    public Controller(Repository repository) {
    }

    public ResponseEntity<?> versions() {
        return ResponseEntity.notFound().build();
    }
}
