package example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount {

    public final double ATM_FEE = 1.0;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    public void withdraw(int userID, double amount) {
        super.withdraw(userID, amount - ATM_FEE);
    }

    @Override
    public void deposit(int userID, double amount) {
        super.deposit(userID, amount - ATM_FEE);
    }
}
