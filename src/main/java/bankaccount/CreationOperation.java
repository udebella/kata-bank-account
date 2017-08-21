package bankaccount;

public class CreationOperation implements Operation {
    private final Amount amount;

    public CreationOperation(Amount amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreationOperation that = (CreationOperation) o;

        return amount.equals(that.amount);
    }

    @Override
    public int hashCode() {
        return amount.hashCode();
    }
}
