package bankaccount;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class BankDepositTest {
    private Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void should_not_be_possible_to_deposit_negative_amount() {
        Assertions.assertThat(bank.makeDeposit(-1)).isFalse();
    }
}
