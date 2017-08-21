package bankaccount;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private Amount amount;
    private List<Operation> operations = new ArrayList<>();

    private Account(Amount amount) {
        operations.add(new CreationOperation(amount));
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

    public List<Operation> getOperations() {
        return operations;
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
