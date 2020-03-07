package javafoundations;

/**
 * Webpage.java
 * Creates a class called Webpage that represents an instance of URL 
 * and implements the Comparable interface.
 * It contains instance data that represent the url string and the number of 
 * lines in the url. The Webpage constructor initializes all data.
 * In addition to getters and setters, the class prints 
 *
 * @author Yaxin(Annie) Liu and Vera Ye
 * @version v2, Oct 13, 2018
 */

import java.util.Scanner;
import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;

public class Webpage implements Comparable<Webpage> {
    // instance variables
    private String url;
    private int lineCounter;
    
    // constructor
    public Webpage(String myUrl) {
        url = myUrl;
        lineCounter = 0;
    }
    
    /*
     * Return url as a string.
     * @return string URL
     */
    public String getURL() {
        return url;
    }
    
    /*
     * Set url to string myUrl.
     */
    public void setURL(String myUrl){
        url = myUrl;
    }
    
    /*
     * Return the lineCounter of one url.
     * @return int lineCounter
     */
    public int getLineCounter(){
        return lineCounter;
    }
    
    /*
     * Set lineCounter to int myCounter.
     */
    public void setLineCounter(int myCounter){
        lineCounter = myCounter;
    }
    
    /* 
     * Read the contents of a web page line by line and store it as a string. 
     * Stop when the end of the web page is reached.
     * 
     * @return String the first 20 characters.
     */
    public String webPageChar(String myUrl) {
        String str = "";
        try {
          URL u = new URL(myUrl);
          Scanner urlScan = new Scanner(u.openStream());
          while (urlScan.hasNext()) {
           String line = urlScan.nextLine();
           str += line;
           lineCounter++;
          }
          urlScan.close(); // close the Scanner
        } catch (IOException ex) {
          System.out.println(ex);
        } 
        return (str.substring(0, 20) + "...");
    }
    
    /*
     * Determine if the url is valid and return a boolean.
     * 
     * @return boolean b whether url is valid or not
     */
    public boolean isValidURL(String myUrl) { 
        boolean b = true;
        URL u = null;
        try{
            u = new URL(myUrl);  
        } catch (MalformedURLException e) {  
            b = false;
            return b;
        }
        
        return b;
    }
    
    /*
     * Return a string representation of the url.
     * 
     * @return string URL
     */
    public String toString(){
        Webpage w = new Webpage(url);
        String webChar = w.webPageChar(url);
        return (url + " : " + w.getLineCounter() + " : " + webChar + "\n");
    }
    
    /*
     * Compare the lineCounter of this Webpage to the lineCounter of other 
     * Webpage. According to the Comparable Interface, return a negative 
     * number, or zero, or a positive number if the lineCounter of this 
     * Webpage is smaller, equal or greater than the inputted one.
     * 
     * @return int indicating who is greater
     */
    public int compareTo(Webpage other){
        //parse each lineCounter to Integer
        return ((Integer)this.lineCounter).
        compareTo((Integer)other.lineCounter); 
    }
}
