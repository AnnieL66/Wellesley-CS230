/**
 * encryptedNamesQueue.java <br>
 * Implements a class called encryptedNamesQueue that performs two types of encryptions
 * given a message. <br>
 * It contains a hardEncrypt method, an easyEncrypt method, and a buildArray method that
 * enqueues the two corresponding encrypted messages into a queue. <br>
 *
 * @author Lizao Wang and Yaxin Liu
 * @version v3, Dec 15 2018
 */

import java.util.*;
import java.lang.*;
import javafoundations.*;

public class encryptedNamesQueue { 
    String message;
    String password = "CSROCKS";
    char[] alphabet = new char[26];

    /**
     * Constructor for the class encryptedNamesQueue
     */
    public encryptedNamesQueue(String myMessage) {
        this.alphabet = new char[]{'A','B','C','D','E','F','G','H','I','J',
            'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'}; 
        this.message = myMessage;
    }

    /**
     * Helper class.
     * Finds the index of characters in password String.
     * 
     * @return int[] shiftNum
     */
    public int[] findShift() {
        int[] shiftNum = new int[password.length()];
        int counter = 0;
        for(int i = 0; i < password.length(); i++){
            for(int j = 0; j < 25; j++){
                if (Character.toUpperCase(password.charAt(i)) == alphabet[j]){
                    shiftNum[counter] = j;
                    counter++; 
                }
            }
        }
        return shiftNum;
    }

    /**
     * Performs a hard encryption.
     * 
     * @param int[] shiftNum that store the shift units found based on password
     * @return char[] encryptedMessage
     */
    public char[] hardEncrypt(int[] shiftNum){
        char[] encryptedMessage = new char[message.length()];
        int counter=0;
        int shiftCounter=0;

        for (int i=0;i<message.length();i++) {
            for(int j=0;j<25;j++) {
                if (Character.toUpperCase(message.charAt(i))==alphabet[j]){
                    if (shiftCounter< shiftNum.length){
                        if (j+shiftNum[shiftCounter]<26){
                            encryptedMessage[counter]=
                            alphabet[j+shiftNum[shiftCounter]];
                            shiftCounter++;
                        } else{
                            encryptedMessage[counter]=
                            alphabet[j+shiftNum[shiftCounter]-26];
                            shiftCounter++;
                        }
                    } else {
                        shiftCounter = 0;
                        if (j+shiftNum[shiftCounter]<26){
                            encryptedMessage[counter]=
                            alphabet[j+shiftNum[shiftCounter]];
                            shiftCounter++;
                        } else{
                            encryptedMessage[counter]=
                            alphabet[j+shiftNum[shiftCounter]-26];
                            shiftCounter++;
                        }
                    }
                    counter++;
                }
            }
        }

        return encryptedMessage;
    }

    /**
     * Performs an easy encryption given a message.
     * 
     * @return char[] encryptedMessage which is the backward song name
     */
    public char[] easyEncrypt(){
        char[] encryptedMessage = new char[message.length()];

        for (int i = message.length()-1; i>=0; i--){
            encryptedMessage[message.length()-1-i] 
            = Character.toUpperCase(message.charAt(i));
        }

        return encryptedMessage;
    }

    /**
     * Helper method that turns a char array to String.
     * 
     * @param char[] inputArray
     * @String result
     */
    public String toString(char[] inputArray){
        String result = "";

        for (int i = 0; i < inputArray.length; i++){
            result += inputArray[i];
        }

        return result;
    }

    /**
     * Build a corresponding ArrayQueue that contains the two encrypted Strings.
     * 
     * @return ArrayQueue<String> that contains the encrypted results
     */
    public ArrayQueue<String> buildArray(){
        ArrayQueue<String> resultQueue = new ArrayQueue();
        resultQueue.enqueue(toString(hardEncrypt(findShift())));
        resultQueue.enqueue(toString(easyEncrypt()));
        return resultQueue;
    }

    // /**
    // * A main class for testing purpose
    // */
    // public static void main(String args[]) {
    // encryptedNamesQueue test1 = new encryptedNamesQueue("hahaha");
    // //System.out.println(test1.toString(test1.hardEncrypt(test1.findShift())));
    // //System.out.println(test1.toString(test1.easyEncrypt()));
    // ArrayQueue<String> q = test1.buildArray();
    // System.out.println(q.dequeue());
    // System.out.println(q.dequeue());
    // }
}
