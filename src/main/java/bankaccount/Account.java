package bankaccount;

public class Account {
    private Amount amount;

    public Account(Amount amount) {
        this.amount = amount;
    }

    public Amount accountBalance() {
        return amount;
    }

    public void deposit(Amount amount) {
        this.amount = this.amount.add(amount);
    }

    public void withdraw(Amount amount) throws NotEnoughMoney {
        this.amount = this.amount.substract(amount);
    }

    @Override
    public String toString() {
        return "Account{" +
                "amount=" + amount +
                '}';
    }

    public static Account fromAmount(Amount startingAmount) {
        return new Account(startingAmount);
    }
}
