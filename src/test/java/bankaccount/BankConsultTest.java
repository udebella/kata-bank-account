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
        bank.addAccount(AccountNumber.fromNumber(1), Amount.fromValue(0));
    }

    @Test(expected = AccountNotFoundException.class)
    public void should_throw_an_exception_when_account_is_not_found() throws Exception {
        AccountNumber accountNumber = AccountNumber.fromNumber(5);
        bank.consult(accountNumber);
    }

    @Test
    public void account_should_have_empty_history_by_default() throws Exception {
        AccountNumber accountNumber = AccountNumber.fromNumber(1);

        assertThat(bank.consult(accountNumber)).isEqualTo(Collections.singletonList(new CreationOperation(Amount.fromValue(0))));
    }
}
