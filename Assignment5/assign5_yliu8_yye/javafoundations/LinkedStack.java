package javafoundations;

import javafoundations.exceptions.*;

/**
*  LinkedStack.java       Java Foundations
*  
*  Implements a class called LinkedStack that Represents a linked 
*  implementation of a stack. It prints out the elements in the stack
*  
*  @author Yaxin(Annie) Liu
*  @version Oct 10, 2018
*/

public class LinkedStack<T> implements Stack<T>
{
   private int count;
   private LinearNode<T> top;

   /**
   *  Creates an empty stack using the default capacity.
   */
   public LinkedStack()
   {
      count = 0;
      top = null;
   }

   /**
   *  Removes the element at the top of this stack and returns a
   *  reference to it. Throws an EmptyCollectionException if the
   *  stack contains no elements.
   * 
   * @return the element at the top of the stack
   */
   public T pop() throws EmptyCollectionException
   {
      if (count == 0)
         throw new EmptyCollectionException ("Pop operation failed. "
            + "The stack is empty.");

      T result = top.getElement();
      top = top.getNext();
      count--;

      return result;
   }

   /**
   *  Returns a string representation of this stack.
   * 
   * @return the elements in the stack
   */
   public String toString()
   {
      String result = "<top of stack>\n";
      LinearNode current = top;

      while (current != null)
      {
         result += current.getElement() + "\n";
         current = current.getNext();
      }

      return result + "<bottom of stack>";
   }

   /**
   *  Add the element at the top of this stack and increment count
   */
   public void push (T element) {
        LinearNode<T> newNode = new LinearNode<T>(element);
        newNode.setNext(top);
        top = newNode;
        count++;
    }
    
   /**
   *  Return the item most recently added to this stack and Throws an 
   *  EmptyCollectionException if the stack contains no elements.
   */
   public T peek () throws EmptyCollectionException { 
       if (isEmpty()) throw new EmptyCollectionException("Stack underflow");
       return top.getElement();
       }
   
   /**
   *  Return true if this stack is empty; false otherwise
   */
   public boolean isEmpty() { 
       return count == 0; 
    }
    
   /**
   * Return the number of items in the stack.
   */
   public int size() { 
       return count;
    }
}
