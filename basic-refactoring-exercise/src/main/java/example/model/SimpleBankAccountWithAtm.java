package example.model;

/**
 * This class represent a particular instance of a BankAccount where the ATM fee is applied
 */
public class SimpleBankAccountWithAtm extends SimpleBankAccount {

    public static final double ATM_FEE = 1.0;

    /**
     * Constructor for the SimpleBankAccountWithAtm
     *
     * @param holder  The account holder
     * @param balance The initial balance
     */
    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }


    /**
     * Withdraws the amount from the account taking into account the ATM fee
     *
     * @param userID the id of the user that wants do the withdrawal
     * @param amount the amount of the withdrawal
     */
    @Override
    public void withdraw(int userID, double amount) {
        super.withdraw(userID, amount + ATM_FEE);
    }

    /**
     * Deposits the amount to the account taking into account the ATM fee
     *
     * @param userID the id of the user that wants do the deposit
     * @param amount the amount of the deposit
     */
    @Override
    public void deposit(int userID, double amount) {
        super.deposit(userID, amount - ATM_FEE);
    }
}
