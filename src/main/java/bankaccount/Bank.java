package bankaccount;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<AccountNumber, Account> accounts = new HashMap<>();

    public Account makeDeposit(AccountNumber accountNumber, Amount amount) {
        Account account = accounts.get(accountNumber);
        account.deposit(amount);
        return account;
    }

    public void addAccount(AccountNumber accountNumber) {
        accounts.put(accountNumber, new Account());
    }
}
