
/**
 * Represents a saving account.
 *
 * @author (Yaxin Liu)
 * @version (9/19/18)
 */
import java.text.NumberFormat;
public class SavingAccount extends Account
{
    // instance variables - replace the example below with your own
    private double interestRate;
    
    // Sets up this checking account using initial deposit.
    public SavingAccount(int initialDeposit, double rate){
        super(initialDeposit);
        interestRate = rate;
    }
    
    // Withraws amount from account if there is enough to draw against.
    public void withdraw(int amount){
        // can empty the bank account 
        if(balance >= amount){
            balance -= amount;
        }else{
            System.out.println("Not enought money in Saving Account. Unable to Withdraw");
        }
    }
    
    // Recalculates the balance by applying interest monthly
    public void recalculateBalance(){
        double interest = balance * interestRate * (1/12.0);
        deposit(interest);
    }
    
    // Returns a formatted string of the instance values
    public String toString(){
        String s = super.toString();
        NumberFormat fmt = NumberFormat.getPercentInstance();
        return s + "\n Interest Rate: " + fmt.format(interestRate);
    }
}
