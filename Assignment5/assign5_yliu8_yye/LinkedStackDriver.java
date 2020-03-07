 /**
 * Test LinkedStack
 *
 * @author (Yaxin Liu)
 * @version (10/10/18)
 */
import javafoundations.*;

public class LinkedStackDriver
{
    public static void main(String[] args) {
        Stack<String> s = new LinkedStack<String>();
	System.out.println("Before pushing: \n" + s);
	// Test push method
	s.push("Computer");
	s.push("Science");
	System.out.println("After pushing: \n" + s);
	// Test pop method
	System.out.println("Pop returns " + s.pop());
	System.out.println("After popping: \n " + s);
	// Test size method
	System.out.println("Size: " + s.size());
	// Test isEmpty method
	System.out.println("Is empty: " + s.isEmpty());

	s.push("I");
	s.push("Love");
	s.push("Wellesley");
	System.out.println("After pushing: \n " + s);
	// Test peek method
	System.out.println("Peek:" + s.peek());
	System.out.println("Pop returns " + s.pop());
	System.out.println("Pop returns " + s.pop());
	System.out.println("Pop returns " + s.pop());
	System.out.println("Pop returns " + s.pop());
	System.out.println("After popping: \n " + s);
	System.out.println("Size: " + s.size());
	// Test isEmpty method
	System.out.println("Is empty: " + s.isEmpty());
	// Edge case: test pop method
	System.out.println("Pop returns " + s.pop());
}
}
