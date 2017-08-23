package bankaccount;

public class CreationOperation extends Operation {
    public CreationOperation(Amount amount) {
        super(amount);
    }

    @Override
    public String toString() {
        return "CreationOperation{" +
                "amount=" + amount +
                '}';
    }
}
