
/**
 * This class creates a bank account
 *
 * @author (Yaxin Liu)
 * @version (9/19/18)
 */

import java.text.NumberFormat;
public abstract class Account
{
    protected int accountNumber;
    protected double balance;
    private static int numberOfAccounts = 0;

    public Account(){
        balance = 0;
    }
    
    // Sets up this account using the specified information.
    public Account(int initialDeposit){
        balance = initialDeposit;
        accountNumber = numberOfAccounts+1;
        numberOfAccounts++;
    }
    
    // Deposits amount to the account.
    public final void deposit(double amount){
        balance += amount;
    }
    
    // Returns a formatted string of the instance values.
    public String toString(){
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        String s = "Bank account number: " + accountNumber + "\n Balance: "
        + fmt.format(balance);
        return s;
    }
    
    public abstract void withdraw(int amount);

}
           