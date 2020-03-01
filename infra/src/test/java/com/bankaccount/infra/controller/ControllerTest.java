package com.bankaccount.infra.controller;

import com.bankaccount.domain.operations.Operation;
import com.bankaccount.infra.repository.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ControllerTest {

    private Controller controller;
    private Repository repository;

    @BeforeEach
    void setUp() {
        repository = mock(Repository.class);
        controller = new Controller(repository);
    }

    @Test
    void should_return_no_versions_when_repository_is_empty() {
        doReturn(Collections.emptyList()).when(repository).operations();

        final ResponseEntity<?> response = controller.versions();

        assertThat(response).isEqualTo(ResponseEntity.notFound().build());
    }

    @Test
    void should_return_list_of_versions() {
        doReturn(Collections.singletonList(mock(Operation.class))).when(repository).operations();

        final ResponseEntity<?> response = controller.versions();

        assertThat(response).isEqualTo(ResponseEntity.ok(new Versions(1)));
    }
}
