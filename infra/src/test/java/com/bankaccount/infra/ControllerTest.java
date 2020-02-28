package com.bankaccount.infra;

import com.bankaccount.domain.operations.Deposit;
import com.bankaccount.domain.operations.Operation;
import infra.Repository;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ControllerTest {
    @Test
    void should_return_no_versions_when_repository_is_empty() {
        final Repository repository = mock(Repository.class);
        final Controller controller = new Controller(repository);
        doReturn(Collections.emptyList()).when(repository).operations();

        final ResponseEntity<?> response = controller.versions();

        assertThat(response).isEqualTo(ResponseEntity.notFound().build());
    }

    @Test
    void should_return_list_of_versions() {
        final Repository repository = mock(Repository.class);
        final Controller controller = new Controller(repository);
        doReturn(Collections.singletonList(mock(Operation.class))).when(repository).operations();

        final ResponseEntity<?> response = controller.versions();

        assertThat(response).isEqualTo(ResponseEntity.ok(new Versions(1)));
    }
}
