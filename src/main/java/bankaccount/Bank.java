package bankaccount;

public class Bank {
    public Account makeDeposit(AccountNumber accountNumber, Amount amount) {
        final Account account = new Account();
        account.deposit(amount);
        return account;
    }
}
