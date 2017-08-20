package bankaccount;

import bankaccount.Amount.AmountBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BankDepositTest {
    private Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void deposit_should_update_account_balance() {
        final Amount amount = new AmountBuilder()
                .withValueAsCents(10)
                .build();

        Account account = bank.makeDeposit(amount);
        assertThat(account.accountBalance())
                .isEqualTo(new AmountBuilder().withValueAsCents(10).build());
    }
}
