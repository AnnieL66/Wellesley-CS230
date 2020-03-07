
/**
 * Makes correct change for a specified amount of money
 *
 * @author (Yaxin Liu)
 * @version (9/8/18)
 */
import java.util.Scanner;

public class CorrectChange
{
    // instance variables - replace the example below with your own;
    private int total;
    private String denominationName;
    private String denomination;
    
    /**
     * Constructor for objects of class CorrectChange
     */
        
    public static void main(String[] args)
    {
        // initialise instance variables
        Scanner scan = new Scanner(System.in);
        System.out.println("How much money do you want to make change for?");
        double money = scan.nextDouble();
        int cents = (int) Math.round(100*money);
        
        System.out.println("We can make change for $" + money + " using: ");
        
        int twenties = makeChangeWithOneDenomination(cents, "$20 dollars", 2000);
        int tens = makeChangeWithOneDenomination(twenties, "$10 dollars", 1000);
        int fives = makeChangeWithOneDenomination(tens, "$5 dollars", 500);
        int dollar = makeChangeWithOneDenomination(fives, "$1 dollars", 100);
        int quarters = makeChangeWithOneDenomination(dollar, "quarters", 25);
        int dimes = makeChangeWithOneDenomination(quarters, "dimes", 10);
        int nickels = makeChangeWithOneDenomination(dimes, "nickels", 5);
        int pennies = makeChangeWithOneDenomination(nickels, "pennies", 1);
    }

    public static int makeChangeWithOneDenomination(int total, 
    String denominationName, int denomination){
        int rolling = total/denomination;
        if(rolling != 0){
        System.out.println(rolling + " " + denominationName);
    }
        int remainder = total % denomination;
        return remainder;
}
}
