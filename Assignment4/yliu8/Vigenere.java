
/**
 * This class allows encryption and decryption of the message using password
 * 
 * @author (Yaxin Liu)
 * @version (9/28/18)
 */
import javax.swing.JOptionPane;

public class Vigenere implements Encryptable
{
    // instance variable
    private String message;
    private String key;
    
    /**
     * Constructor for objects of class Vigenere
     */
    public Vigenere(String n, String k){
        message = n.toUpperCase().replaceAll(" ", "");
        key = k.toUpperCase();
    }
    
    //-----------------------------------------------------------------
    //  Encrypt and Decrypt message using password.
    //  Uses multiple dialog boxes for user interaction.
    //-----------------------------------------------------------------
    
    public static void main(String[] args){
        String str, str1, result;
        int again;
        
        try{
        str = JOptionPane.showInputDialog ("What is the message?");
        System.out.println("The message is " + str);
       
        str1 = JOptionPane.showInputDialog ("What is the password?");
        System.out.println("The password is " + str1);
        
        Vigenere vin = new Vigenere(str, str1);
        
        vin.test(str);
        vin.test(str1);
        
        //test encrypt method
        vin.encrypt();
        JOptionPane.showMessageDialog (null, vin);
        System.out.println("The encrypted message is " + vin);
        again = JOptionPane.showConfirmDialog (null, "Do you want it decrypted?");
         
         if(again == JOptionPane.YES_OPTION){
         String decryptMsg = vin.decrypt();
         JOptionPane.showMessageDialog (null,decryptMsg);
         System.out.println("The decrypted message is " + decryptMsg);
         
        }else if (again == JOptionPane.NO_OPTION ||
         again == JOptionPane.CANCEL_OPTION){
         System.exit(0);
        }
        
        }catch(NullPointerException ex){
            JOptionPane.showMessageDialog (null, "Failed. Please Try Again");
            System.out.println("Failed. Please Try Again");
            System.exit(0);
    }
}
    
    // encryption using a password
    // match one character in the password to one character of original message in order
    // add the character in the key as in position of the alphabet to the character it matches
    // loop password
    public void encrypt(){
        String str = "";
        int p = 0;
        char[] newKey = key.toCharArray();
        for (int i = 0; i < message.length(); i++){
            p = i % (newKey.length);  
            int n = newKey[p] - (int)'A';
            n = message.charAt(i) + n;
            if(n > (int)'Z'){
                n = newKey[p]-((int)'Z'- message.charAt(i)+1);
            }
            str += Character.toString((char)n);
        }
        message = str;
    }
    
    // decrypition using a password
    public String decrypt(){
        String str = "";
        int p = 0;
        char[] newKey = key.toCharArray();
        for (int i = 0; i < message.length(); i++){
            p = i % (newKey.length);  
            int n = newKey[p] - (int)'A';
            n = message.charAt(i) - n;
            if(n < (int)'A'){
                n = message.charAt(i)+((int)'Z'- newKey[p] +1);
            }
            str += Character.toString((char)n);
        }
        message = str;
        return message;
    }
    
    // toString method; return message as a String
    public String toString(){
        return message;
    }
    
    // test if there is punctuation in the sentence
    public void test(String str){
        for(int i = 0; i < str.length(); i++){
        if(str.charAt(i) == '&'|| str.charAt(i) == '%' || 
        str.charAt(i) == '!'|| str.charAt(i) == '$' || str.charAt(i) == '@'
        || str.charAt(i) == '#' || str.charAt(i) == ','|| str.charAt(i) == '.' 
        || str.charAt(i) == '@' || str.charAt(i) == ';'){
            System.out.println("Failed. No punctuation allowed in the message.");
            System.exit(0);
        }
    }
}
}
