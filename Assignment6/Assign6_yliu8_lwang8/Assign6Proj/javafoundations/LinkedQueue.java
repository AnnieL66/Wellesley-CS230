package javafoundations;

/**
*  LinkedQueue.java       Java Foundations
*  
*  Implements a class called LinkedQueue that represents a linked 
*  implementation of a queue. It prints out the elements in the queue.
*  
*  @author Yaxin(Annie) Liu
*  @version Oct 20, 2018
*/

import javafoundations.exceptions.*;

public class LinkedQueue<T> implements Queue<T>
{
   private int count;
   private LinearNode<T> front, rear;

   /**
    * Creates an empty queue using the default capacity.
    */
   public LinkedQueue()
   {
      count = 0;
      front = rear = null;
   }

   /**
    *  Adds the specified element to the rear of this queue.
    *  @param value the item to insert.
    */
   public void enqueue (T element)
   {
      LinearNode<T> node = new LinearNode<T>(element);

      if (count == 0)
         front = node;
      else
         rear.setNext(node);

      rear = node;
      count++;
   }

   /**
    * Removes the element at the front of this queue and returns a
    * reference to it. Throws an EmptyCollectionException if the
    * queue is empty.
    */
   public T dequeue () throws EmptyCollectionException { 
      if (isEmpty()){
         throw new EmptyCollectionException ("queue");
      }

      T result = front.getElement();
      front = front.getNext();
      count--;

      if (isEmpty()){
         rear = null;
        }
        
      return result;
    }
    
   /** 
    * Returns a reference to the element at the front of this queue.
    * Throws an EmptyCollectionException if the queue is empty.
    */
   public T first () throws EmptyCollectionException { 
       if (isEmpty()){
         throw new EmptyCollectionException ("queue"); 
        }

      return front.getElement();
   }
    
   /**
    * Return the number of items in the Array Queue.
    */
   public int size() { 
       return count;
    }
    
   /**
    *  Return true if this Queue is empty; false otherwise
    */
   public boolean isEmpty() { 
       return count == 0;
    }
    
   /**
    * Returns a string representation of this queue.
    */
   public String toString() { 
      String result = "";
      LinearNode<T> current = front;

      while (current != null)
      {
         result = result + (current.getElement()).toString() + "\n";
         current = current.getNext();
      }

      return result;
    }
}
