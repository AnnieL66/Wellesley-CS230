
/**
 * This program tests the BankAccount class and its subclasses. 
 *
 * @author (Yaxin Liu)
 * @version (9/19/18)
 */
public class Tester
{
    public static void main(String[] args){
        CheckingAccount check1 = new CheckingAccount(1000); 
        SavingAccount save1 = new SavingAccount(5000, 0.05);
        
        // Depositing another $800 into Checkings
        check1.deposit(800);
        System.out.println(check1.toString());
        
        // Depositing another $1000 into Saving.
        save1.deposit(1000);
        System.out.println(save1.toString());
        
        // Recalculating balance on saving account
        ((SavingAccount)save1).recalculateBalance();
        System.out.println(save1.toString());

        // Withdrawing $7000; more than available from checkings
        check1.withdraw(7000);
        System.out.println(check1.toString());
        
        // Withdrawing $1601 from checkings
        check1.withdraw(1601);
        System.out.println(check1.toString());
        
        // Withdrawing $ 10000; More than available from savings
        save1.withdraw(10000);
        System.out.println(save1.toString());
    }
}
