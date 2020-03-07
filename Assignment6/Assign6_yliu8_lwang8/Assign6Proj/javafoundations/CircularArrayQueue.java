package javafoundations;

/**
*  CircularArrayQueue.java       Java Foundations
*  
*  Implements a class called CircularArrayQueue that represents 
*  an array implementation of a queue in which neither end of 
*  the queue is fixed in the array. The variables storing the 
*  indexes of the front and rear of the queue continually increment
*  as elements are removed and added, cycling back to 0 when they
*  reach the end of the array. It prints out the elements in the queue.
*  
*  @author Yaxin(Annie) Liu
*  @version Oct 20, 2018
*/

import javafoundations.exceptions.*;

public class CircularArrayQueue<T> implements Queue<T>
{
  private final int DEFAULT_CAPACITY = 3;
  private int front, rear, count;
  private T[] queue;
  
  /**
    * Creates an empty queue using the default capacity.
    */
  public CircularArrayQueue()
  {
    front = rear = count = 0;
    queue = (T[]) (new Object[DEFAULT_CAPACITY]);
  }
  
  /**
   * Adds the specified element to the rear of this queue, expanding
   * the capacity of the queue array if necessary.
   */
  public void enqueue (T element)
  {
    if (count == queue.length)
      expandCapacity();
    
    queue[rear] = element;
    rear = (rear+1) % queue.length;
    count++;
  }
  
  /**
   * Creates a new array to store the contents of this queue with
   * twice the capacity of the old one.
   */
  public void expandCapacity()
  {
    T[] larger = (T[])(new Object[queue.length*2]);
    
    for (int index=0; index < count; index++)
      larger[index] = queue[(front+index) % queue.length];
    
    front = 0;
    rear = count;
    queue = larger;
  }
  
  /**
   * Removes the element at the front of this queue and returns a
   * reference to it. Throws an EmptyCollectionException if the
   * queue is empty.
   */
   public T dequeue () throws EmptyCollectionException {
      if (isEmpty()){
         throw new EmptyCollectionException ("Dequeue operation failed. "
            + "The queue is empty.");
        }
        
      T result = queue[front];
      queue[front] = null;

      front = (front+1) % queue.length;

      count--;

      return result;
    }
   
   /** 
    * Returns a reference to the element at the front of this queue.
    * Throws an EmptyCollectionException if the queue is empty.
    */
   public T first () throws EmptyCollectionException { 
       if (isEmpty()){
            throw new EmptyCollectionException ("Empty");
        }
    
        return queue[front];
    }
   
   /**
    * Return the number of items in the Queue.
    */
   public int size() { 
    return count;
   }
   
   /**
    *  Return true if this Queue is empty; false otherwise
    */
   public boolean isEmpty() { 
       return (count == 0);
    }
    
   /**
    * Returns a string representation of this queue.
    */
   public String toString() { 
       String result = "";
       int i = front;
 
       while(i < count){
           if(queue[i] != null){
               result += queue[i].toString()+"\n";
            }
           i++;
        }
        return result;
    }
}