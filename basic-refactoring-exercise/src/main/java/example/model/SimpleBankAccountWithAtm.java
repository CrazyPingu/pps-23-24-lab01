package example.model;

/**
 * This class represent a particular instance of a BankAccount where the ATM fee is applied
 */
public class SimpleBankAccountWithAtm extends SimpleBankAccount {

    /**
     * The ATM fee.
     * If negative, it is not applied
     */
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
     * Withdraws the amount from the account taking into account the ATM fee.
     * If the ATM fee is negative, it is not applied.
     *
     * @param userID the id of the user that wants do the withdrawal
     * @param amount the amount of the withdrawal
     */
    @Override
    public void withdraw(int userID, double amount) {
        double newAmount = amount + (ATM_FEE < 0 ? 0 : ATM_FEE);
        super.withdraw(userID, newAmount);
    }

    /**
     * Deposits the amount to the account taking into account the ATM fee
     * If the ATM fee is negative, it is not applied.
     *
     * @param userID the id of the user that wants do the deposit
     * @param amount the amount of the deposit
     */
    @Override
    public void deposit(int userID, double amount) {
        double newAmount = amount - (ATM_FEE < 0 ? 0 : ATM_FEE);
        super.deposit(userID, newAmount);
    }
}
