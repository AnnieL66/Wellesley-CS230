/**
 * usersGuess.java <br>
 * A helper class that implements the Comparable interface and compares user's input 
 * with a provided songName String. <br>
 *
 * @author Vera Ye and Yaxin Liu
 * @version v2, Dec 14, 2018
 */

public class usersGuess implements Comparable<usersGuess> {
    private String guess; 

    /**
     * Constructor for usersGuess class
     */
    public usersGuess(String myGuess) {
        this.guess = myGuess;
    }

    /**
     * A getter that returns user's guess.
     * 
     * @return String guess
     */
    public String getGuess(){
        return guess;
    }

    /**
     * Compare the original songName String to the user input (guessed)
     * songName String. 
     * According to the Comparable Interface, 
     * return zero if the two Strings are the same, or 
     * return a negative or positive number if the two Strings are different. 
     * 
     * @param usersGuess g
     * @return int indicating if the two Strings are the same
     */
    public int compareTo(usersGuess g) {
        return this.getGuess().compareTo(g.getGuess());
    }
}
