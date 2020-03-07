
/**
 * Test BoundedQueue.
 *
 * @author (Yaxin Liu)
 * @version (10/26/18)
 */
import javafoundations.*;

public class BoundedQueueDriver
{
    public static void main(String[] args){
    BoundedQueue <Integer> s = new BoundedQueue<Integer>(4);
    System.out.println("Test BoundedQueue Enqueue: ");
    s.enqueue(2);
    s.enqueue(3);
    s.enqueue(4);
    s.enqueue(5);
    System.out.println(s.toString());
    System.out.println("Is Full:" + s.isFull());
    System.out.println("Delete an item from queue (should be 3): " 
                        + s.dequeue());    
    System.out.println("Size of the queue (should be 3): " + s.size());
    System.out.println("Is Empty:" + s.isEmpty());
    System.out.println("Return the front element:" + s.first() +"\n");
    // Test Edge Case (if size > DEFAULT_CAPACITY)
    System.out.println("Test Edge Case (if size > Default capacity): ");
    s.enqueue(6);
    s.enqueue(7);
    System.out.println(s.toString());
  }
}
