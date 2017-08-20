package bankaccount;

import bankaccount.Amount.AmountBuilder;
import org.junit.Before;
import org.junit.Test;

import static bankaccount.AccountNumber.AccountNumberBuilder;
import static org.assertj.core.api.Assertions.assertThat;

public class BankDepositTest {
    private AccountNumberBuilder accountNumberBuilder;
    private AmountBuilder amountBuilder;
    private Bank bank;

    @Before
    public void setUp() {
        accountNumberBuilder = new AccountNumberBuilder();
        amountBuilder = new AmountBuilder();

        bank = new Bank();
        bank.addAccount(accountNumberBuilder.withNumber(1).build());
        bank.addAccount(accountNumberBuilder.withNumber(2).build());
    }

    @Test
    public void deposit_should_update_account_balance() {
        final Amount amount = amountBuilder.withValueAsCents(10).build();
        final AccountNumber accountNumber = accountNumberBuilder.withNumber(1).build();

        Account account = bank.makeDeposit(accountNumber, amount);

        assertThat(account.accountBalance())
                .isEqualTo(amountBuilder.withValueAsCents(10).build());
    }

    @Test
    public void depositing_two_times_in_a_row_on_the_same_account_should_update_the_account() {
        final Amount amount = amountBuilder.withValueAsCents(10).build();
        final AccountNumber accountNumber = accountNumberBuilder.withNumber(1).build();

        bank.makeDeposit(accountNumber, amount);
        Account account = bank.makeDeposit(accountNumber, amount);

        assertThat(account.accountBalance())
                .isEqualTo(amountBuilder.withValueAsCents(20).build());
    }

    @Test
    public void should_manage_multiple_different_accounts() {
        final Amount amount = amountBuilder.withValueAsCents(10).build();
        final AccountNumber accountNumber = accountNumberBuilder.withNumber(1).build();
        final AccountNumber accountNumber2 = accountNumberBuilder.withNumber(2).build();

        Account account = bank.makeDeposit(accountNumber, amount);
        Account account2 = bank.makeDeposit(accountNumber2, amount);

        assertThat(account).isNotEqualTo(account2);
    }
}
