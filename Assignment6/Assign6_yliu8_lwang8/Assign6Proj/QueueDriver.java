
import javafoundations.*;

/**
 * Test LinkedQueue, ArrayQueue, and CircularArrayQueue.
 *
 * @author (Yaxin Liu)
 * @version (10/20/18)
 */

public class QueueDriver
{
    public static void main(String[] args){
    Queue <Integer> q = new LinkedQueue<Integer>();
    System.out.println("Test LinkedQueue Enqueue: ");
    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);
    q.enqueue(40);
    System.out.println(q.toString());
    System.out.println("Delete an item from queue (should be 10): " 
                        + q.dequeue());    
    System.out.println("Size of the queue (should be 3): " + q.size());
    System.out.println("Is Empty:" + q.isEmpty());
    System.out.println("Return the front element:" + q.first());
    
    System.out.println("Delete all items from queue: " + q.dequeue() +
    " " + q.dequeue() + " " + q.dequeue());
    System.out.println("Is Empty:" + q.isEmpty());
    // Test Edge Case (if size = 0);
    System.out.println("Test Edge Case (delete an item if size = 0) ");
    q.dequeue();
    
    // Test CircularArrayQueue
    Queue <String> s = new CircularArrayQueue<String>();
    System.out.println("Test CircularArrayQueue Enqueue: ");
    s.enqueue("I");
    s.enqueue("Love");
    s.enqueue("Wellesley");
    System.out.println(s.toString());
    System.out.println("Delete an item from queue (should be \"I\"): " 
                        + s.dequeue());    
    System.out.println("Size of the queue (should be 2): " + s.size());
    System.out.println("Is Empty:" + s.isEmpty());
    System.out.println("Return the front element:" + s.first() +"\n");
    // Test Edge Case (if size > DEFAULT_CAPACITY)
    System.out.println("Test Edge Case (if size > Default capacity): ");
    s.enqueue("Happy");
    s.enqueue("Everyday");
    s.enqueue("YEAH");
    System.out.println(s.toString());
    System.out.println("Size of the queue (should be 5): " + s.size());
    System.out.println("Delete all items from queue: " + s.dequeue() +
    " " + s.dequeue() + " " + s.dequeue() + " " +  s.dequeue() + " " +
    s.dequeue());
    //Test Edge Case (if size = 0);
    System.out.println("Test Edge Case (delete an item if size = 0) ");
    s.dequeue();
    
    // Test ArrayQueue
    Queue <Character> c = new CircularArrayQueue<Character>();
    System.out.println("Test ArrayQueue Enqueue: ");
    c.enqueue('a');
    c.enqueue('b');
    c.enqueue('c');
    System.out.println(c.toString());
    System.out.println("Delete an item from queue (should be 'a'): " 
                        + c.dequeue());    
    System.out.println("Size of the queue (should be 2): " + c.size());
    System.out.println("Is Empty:" + c.isEmpty());
    System.out.println("Return the front element:" + c.first() +"\n");
    
    System.out.println("Delete all items from queue: " + c.dequeue() +
    " " + c.dequeue());
    System.out.println("Is Empty:" + c.isEmpty());
    
    // Test Edge Case (if size = 0);
    System.out.println("Test Edge Case (delete an item if size = 0) ");
    c.dequeue();
  }
}
