package javafoundations;

/**
*  ArrayQueue.java       Java Foundations
*  
*  Implements a class called ArrayQueue that represents an array 
*  implementation of a queue. The front of the queue is kept at 
*  array index 0.It prints out the elements in the queue.
*  
*  @author Yaxin(Annie) Liu
*  @version Oct 20, 2018
*/

import javafoundations.exceptions.*;

public class ArrayQueue<T> implements Queue<T>
{
    private final int DEFAULT_CAPACITY = 10;
    private int count;
    private T[] queue;

   /**
    * Creates an empty queue using the default capacity.
    */
    public ArrayQueue(){
      count = 0;
      queue = (T[]) (new Object[DEFAULT_CAPACITY]);
   }

   /**
    * Removes the element at the front of this queue and returns a
    * reference to it. Throws an EmptyCollectionException if the
    * queue is empty.
    */
    public T dequeue() throws EmptyCollectionException{
      if (count == 0)
         throw new EmptyCollectionException ("Dequeue operation failed. "
            + "The queue is empty.");

      T result = queue[0];

      count--;

      // shift the elements to keep the front element at index 0
      for (int index=0; index < count; index++)
         queue[index] = queue[index+1];

      queue[count] = null;

      return result;
   }

   /**
    *  Adds the specified element to the rear of this queue.
    *  @param value the item to insert.
    */
    public void enqueue (T element) { 
         queue[count] = element;
         count++;
    }
    
   /** 
    * Returns a reference to the element at the front of this queue.
    * Throws an EmptyCollectionException if the queue is empty.
    */
     public T first () throws EmptyCollectionException { 
        if (isEmpty()){
            throw new EmptyCollectionException ("Empty");
        }
    
        return queue[0];
    }
    
   /**
    *  Return true if this Queue is empty; false otherwise
    */
    public boolean isEmpty() { 
        return count == 0;
    }
    
   /**
    * Return the number of items in the Array Queue.
    */
    public int size() {
        return count;
    }
    
   /**
    * Returns a string representation of this queue.
    */
    public String toString() { 
        String result = "";

        for (int i=0; i < count; i++){
            result = result + queue[i].toString() + "\n";
        }
        
        return result;
    }
}
