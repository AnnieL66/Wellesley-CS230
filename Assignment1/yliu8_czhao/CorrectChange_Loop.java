
/**
 * Makes correct change for a specified amount of money using loop
 *
 * @author (Yaxin Liu)
 * @version (9/8/18)
 */

import java.util.*;

public class CorrectChange_Loop
{
    // instance variables - replace the example below with your own;

    /**
     * Constructor for objects of class CorrectChange
     */
        
    public static void main(String[] args)
    {
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
        int numberOfCoins = 0;
        for(int x = total - denomination; x>=0; x = x - denomination){
            numberOfCoins++;
    }
        if(numberOfCoins != 0){
            System.out.println(numberOfCoins + " " + denominationName);
        }
        int remainder = total % denomination;
        return remainder;
}
}