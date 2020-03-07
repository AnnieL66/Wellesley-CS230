
/**
 * Defines some class methods that process Strings using iteration and 
 * recursion, to perform tasks like removing a character from a String 
 * and testing whether two Strings are anagrams.
 *
 * @author (Yaxin Liu)
 * @version (9/13/18)
 */
public class StringOps
{

    /**
     * Constructor for objects of class StringOps
     */
    boolean reults;
    
    public static void main(String[] args){
        // test testAnagrams
        testAnagrams("lemon", "melon");
        testAnagrams("hello", "world");
        // test removeChar
        System.out.println(removeChar("hello", 'e'));
    }
    
    public static String removeChar(String S, char ch){
        String s = "";
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) != ch){
                s += S.charAt(i);
            }
        }
        return s;
    }

    public static void testAnagrams (String word1, String word2){
        boolean result1 = testAnagramsRec(word1, word2);
        if(result1){
            System.out.println(word1 + " and " + word2 + " are anagrams.");
        }else{
            System.out.println(word1 + " and " + word2 + " are not anagrams.");
    }
}
    
    public static boolean testAnagramsRec(String NewWord1, String NewWord2){
        if(NewWord2 == "" && NewWord1 == ""){
            return true;
        }
        
            for(int i = 0; i < NewWord1.length(); i++){
            if(NewWord2.charAt(0) == NewWord2.charAt(i)){
                NewWord2 = removeChar(NewWord2,NewWord2.charAt(0));
                NewWord1 = removeChar(NewWord1,NewWord1.charAt(i));
                return testAnagramsRec(NewWord1, NewWord2);
            }
        }
        return false;
    }
}