package bankaccount;

public class DepositOperation extends Operation {
    public DepositOperation(Amount amount) {
        super(amount);
    }

    @Override
    public String toString() {
        return "DepositOperation{" +
                "amount=" + amount +
                '}';
    }
}
