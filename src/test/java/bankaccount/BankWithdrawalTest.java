package bankaccount;

import bankaccount.AccountNumber.AccountNumberBuilder;
import org.junit.Before;
import org.junit.Test;

public class BankWithdrawalTest {

    private AccountNumberBuilder accountNumberBuilder;
    private Bank bank;

    @Before
    public void setUp() {
        accountNumberBuilder = new AccountNumberBuilder();
        bank = new Bank();

        bank.addAccount(accountNumberBuilder.withNumber(1).build(), Amount.fromValue(1000));
        bank.addAccount(accountNumberBuilder.withNumber(2).build(), Amount.fromValue(0));
    }

    @Test(expected = AccountNotFoundException.class)
    public void should_not_allow_to_withdraw_from_an_unregistered_account() throws Exception {
        final AccountNumber accountNumber = accountNumberBuilder.withNumber(5).build();
        final Amount amount = Amount.fromValue(100);

        bank.withdraw(accountNumber, amount);
    }
}
