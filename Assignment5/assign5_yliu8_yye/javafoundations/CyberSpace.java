package javafoundations;

/**
 * Cyberspace.java
 * Implements a class called Cyberspace that manages a collection of URLs.
 * It prints out the URLs, their line counters, and the first 20 characters 
 * of their contents, in a LIFO manner removing them from the collection.
 * 
 * @author Yaxin(Annie) Liu and Vera Ye
 * @version v2, Oct 13, 2018
 */

import java.util.Scanner;
import java.io.*;
import java.net.URL;

public class CyberSpace {
    // instantiate a collection of Webpage
    private LinkedStack<Webpage> collection;

    // constructor
    public CyberSpace() {
        collection = new LinkedStack<Webpage>();
    }
    
    /* 
     * Read in the contents of a file line by line,
     * and print out each line after it is read in.
     * Stop when the end of the file is reached.
     */
    public void displayFile (String inFileName) {
        try {
            Scanner fileScan = new Scanner (new File(inFileName));
            while (fileScan.hasNext()) {
                String line = fileScan.nextLine();
                Webpage url = new Webpage(line);
                String charStr = url.webPageChar(line);
                collection.push(url);
                System.out.println(url.getURL());
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } 
    }
    
    /* 
     * Read in lines of text from the keyboard,
     * and print out each line after it is read in.
     * Stop when the user enters "q".
     */
    public void displayKeyboardInput() {
       Scanner keyboardScan = new Scanner(System.in);
       String line;
       System.out.println("Please enter URLs (without spaces) below;" +
                           " Type q to quit: ");
       do {
           line = keyboardScan.nextLine();
           if (line.equals("q")){
               break;
           }
           Webpage url = new Webpage(line);
           String charStr = url.webPageChar(line);
           collection.push(url);
       } while (keyboardScan.hasNext() && !(line.equals("q")));
    }
 
    /* 
     * Return a string representation of collection.
     * 
     * @return String str
     */
    public String toString() {
        Webpage temp = new Webpage("");
        String str = "";
        str += ("\nResults from visiting " + collection.size() + " pages: \n");
        while(!(collection.isEmpty())){
            Webpage w = collection.pop();
            if(w.compareTo(temp) > 0){
                temp = w;
            }
            str += w.toString();
        }
        str += ("\nThe largest Webpage was: " + temp.toString());
        return str;
    }
    
    public static void main (String args[]) {
       CyberSpace c = new CyberSpace();
       if (args.length > 0) {
            //the user has inputted at least the first input
            c.displayKeyboardInput();
       } else {
            // display the contents of input file
            c.displayFile("myURLs.txt");
       }
       System.out.println(c.toString());
    }
}
