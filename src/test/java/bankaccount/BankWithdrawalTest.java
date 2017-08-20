package bankaccount;

import bankaccount.AccountNumber.AccountNumberBuilder;
import bankaccount.Amount.AmountBuilder;
import org.junit.Before;
import org.junit.Test;

public class BankWithdrawalTest {

    private AmountBuilder amountBuilder;
    private AccountNumberBuilder accountNumberBuilder;
    private Bank bank;

    @Before
    public void setUp() {
        accountNumberBuilder = new AccountNumberBuilder();
        amountBuilder = new AmountBuilder();
        bank = new Bank();
    }

    @Test(expected = AccountNotFoundException.class)
    public void should_not_allow_to_withdraw_from_an_unregistered_account() throws Exception {
        final AccountNumber accountNumber = accountNumberBuilder.withNumber(5).build();
        final Amount amount = amountBuilder.withValueAsCents(100).build();

        bank.withdraw(accountNumber, amount);
    }
}
