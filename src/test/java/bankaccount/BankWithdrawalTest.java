package bankaccount;

import org.junit.Before;
import org.junit.Test;

public class BankWithdrawalTest {
    private Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();

        bank.addAccount(AccountNumber.fromNumber(1), Amount.fromValue(1000));
        bank.addAccount(AccountNumber.fromNumber(2), Amount.fromValue(0));
    }

    @Test(expected = AccountNotFoundException.class)
    public void should_not_allow_to_withdraw_from_an_unregistered_account() throws Exception {
        final AccountNumber accountNumber = AccountNumber.fromNumber(5);
        final Amount amount = Amount.fromValue(100);

        bank.withdraw(accountNumber, amount);
    }
}
