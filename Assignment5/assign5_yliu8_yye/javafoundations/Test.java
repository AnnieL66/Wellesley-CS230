package javafoundations;

/**
 * Test the Webpage class and its methods.
 *
 * @author Yaxin(Annie) Liu and Vera Ye
 * @version v2, Oct 13, 2018
 */
public class Test {
    
    public static void main (String args[]) {
        // create new Webpage objects (test constructor)
        Webpage w = new Webpage("http://www.google.com");
        Webpage w1 = new Webpage("http://www.bing.com");
        Webpage w2 = new Webpage("http://www.wellesley.edu/cs");
        Webpage w3 = new Webpage("https://www.netflix.com");
        Webpage bad = new Webpage("shajdkajsjdkbaekbk");
        
        // test webPageChar method
        System.out.println("**test webPageChar method");
        String str = w.webPageChar("http://www.google.com");
        String str1 = w1.webPageChar("http://www.bing.com");
        String str2 = w2.webPageChar("http://www.wellesley.edu/cs");
        String str3 = w3.webPageChar("https://www.netflix.com");
        
        System.out.println("Print out first 20 characters of google and bing:");
        System.out.println(str);
        System.out.println(str1);
        
        // test getURL and setURL
        System.out.println("\n**test getURL and setURL");
        System.out.println(w1.getURL());
        w1.setURL("https://www.amazon.com");
        System.out.println(w1.getURL());
        System.out.println(w3.getURL());
        
        // test getLineCounter and setLineCounter
        System.out.println("\n**test getLineCounter and setLineCounter");
        System.out.println(w2.getLineCounter());
        w2.setLineCounter(1081);
        System.out.println(w2.getLineCounter());
        System.out.println(w3.getLineCounter());
        System.out.println(bad.getLineCounter());
        
        // test isValidURL
        System.out.println("\n**test isValidURL");
        System.out.println("Output should be true: " + 
                            w1.isValidURL("http://www.bing.com"));
        System.out.println("Output should be false: " + 
                            bad.isValidURL("shajdkajsjdkbaekbk"));
        
        // test compareTo
        System.out.println("\n**test compareTo");
        System.out.println("Output should be a positive integer: " 
                            + w1.compareTo(w));
        System.out.println("Output should be a negative integer: " 
                            + w3.compareTo(w2));
        
    }
    
}
