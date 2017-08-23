package bankaccount;

import org.junit.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountConsultTest {
    @Test
    public void account_should_have_empty_history_by_default() {
        final Account account = Account.fromAmount(Amount.NULL_AMOUNT);

        assertThat(account.consult()).isEqualTo(Collections.singletonList(new CreationOperation(Amount.NULL_AMOUNT)));
    }

    @Test
    public void should_not_allow_to_modify_account_history() {
        final Account account = Account.fromAmount(Amount.NULL_AMOUNT);

        account.consult().add(new CreationOperation(Amount.NULL_AMOUNT));

        assertThat(account.consult()).isEqualTo(Collections.singletonList(new CreationOperation(Amount.NULL_AMOUNT)));
    }
}
