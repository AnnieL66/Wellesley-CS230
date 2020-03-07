
/**
 * Represents a checking account.
 *
 * @author (Yaxin Liu)
 * @version (9/19/18)
 */

import java.text.NumberFormat;

public class CheckingAccount extends Account
{   
    
    private static int minimumBalance = 200;
    private static int overdraftFee = 50;
    
    public CheckingAccount(int initialDeposit){
        super(initialDeposit);
    }
    
    public void withdraw(int amount){
        // set a minimum balance
        // if they try to pull out more money than they have
        // tell them it's not possible but not pull the money out
        // charge the overdraft feee
        if(amount > balance){
            System.out.println("Not enought money in Checking Account. Unable to Withdraw");
        }else if((balance - amount) > minimumBalance){
            balance -= amount;
        }else{
            System.out.println("Below Minimum Balance. Charge overdraft fees.");
            this.balance = balance - (amount + overdraftFee);
        }            
    }
    
    public String toString(){
        String s = super.toString();
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        return s + "\n Minimum balance is: " + fmt.format(minimumBalance);
    }
}