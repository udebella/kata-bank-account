package bankaccount;

import bankaccount.Amount.AmountBuilder;

public class Account {
    private Amount amount;

    public Account() {
        this.amount = new AmountBuilder().withValueAsCents(0).build();
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
}
