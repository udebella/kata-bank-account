package bankaccount;

public class Bank {
    private final Account account = new Account();

    public Account makeDeposit(AccountNumber accountNumber, Amount amount) {
        account.deposit(amount);
        return account;
    }
}
