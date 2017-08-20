package bankaccount;

public class Account {
    private Amount amount;

    public Account() {
        this.amount = Amount.fromValue(0);
    }

    public Account(Amount amount) {
        this.amount = amount;
    }

    public Amount accountBalance() {
        return amount;
    }

    public void deposit(Amount amount) {
        this.amount = this.amount.add(amount);
    }

    @Override
    public String toString() {
        return "Account{" +
                "amount=" + amount +
                '}';
    }

    public static Account fromAmount(Amount amount) {
        return new Account(amount);
    }
}
