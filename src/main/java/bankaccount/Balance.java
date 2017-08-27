package bankaccount;

public class Balance {
    private final Amount amount;
    private final boolean isPositive;


    private Balance(Amount amount, boolean isPositive) {
        this.amount = amount;
        this.isPositive = isPositive;
    }

    public static Balance of(Amount amount, boolean isPositive) {
        return new Balance(amount, isPositive);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Balance balance = (Balance) o;

        if (isPositive != balance.isPositive) return false;
        return amount.equals(balance.amount);
    }

    @Override
    public int hashCode() {
        int result = amount.hashCode();
        result = 31 * result + (isPositive ? 1 : 0);
        return result;
    }

    public Balance add(Amount amountToAdd) {
        return of(amount.add(amountToAdd), isPositive);
    }
}
