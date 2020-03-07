package javafoundations;

/**
*  BoundedQueue.java       Java Foundations
*  
*  Implements a class called BoundedQueue that represents 
*  an implementation of a queue with a maximum capacity 
*  (no elements can be enqueued when the queue is full to capacity).
*  It prints out the elements in the queue.
*  
*  @author Yaxin(Annie) Liu
*  @version Oct 25, 2018
*/

import javafoundations.*;

public class BoundedQueue<T> extends CircularArrayQueue<T>
{
    // instance variables - replace the example below with your own
    private int capacity;
    
    /**
    * A constructor that takes an integer argument corresponding 
    * to the capacity of the bounded queue.
    */
    public BoundedQueue(int n){
        super();
        capacity = n;
    }
    
    /**
     *  Indicates if the bounded queue is at capacity or not
     */
    public boolean isFull(){
        return (super.size() == capacity);
    }
    
    /**
     * Adds the specified element to the rear of this queue, 
     * only enqueues an element if the queue is not at capacity.
     */
    public void enqueue(T element){
        if (super.size() == capacity)
        throw new IndexOutOfBoundsException ("Queue is at capacity.");
        
        super.enqueue(element);
    }
}
