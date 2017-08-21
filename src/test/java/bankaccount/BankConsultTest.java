package bankaccount;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class BankConsultTest {
    private Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    @Test(expected = AccountNotFoundException.class)
    public void should_throw_an_exception_when_account_is_not_found() throws Exception {
        final AccountNumber accountNumber = AccountNumber.fromNumber(5);

        bank.consult(accountNumber);
    }

    @Test
    public void account_should_have_empty_history_by_default() throws Exception {
        final AccountNumber accountNumber = AccountNumber.fromNumber(1);
        final Amount amount = Amount.fromValue(0);

        bank.addAccount(accountNumber, amount);

        assertThat(bank.consult(accountNumber)).isEqualTo(Collections.singletonList(new CreationOperation(amount)));
    }
}
