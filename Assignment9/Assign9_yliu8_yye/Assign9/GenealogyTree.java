
/**
 * GenealogyTree.java
 * Implements a binary tree using an array with computed links strategy.
 * 
 * @author Yaxin(Annie) Liu
 * @version Nov 25, 2018
 */

import javafoundations.*;
import javafoundations.exceptions.*;
import java.util.Iterator;

public class GenealogyTree<T> implements AncestryTree<T>, Iterable<T>
{
    // The root node of the GenealogyTree 
    private final int DEFAULT_CAPACITY = 10;
    private T[] result;
    
    public GenealogyTree(){
        result = (T[])(new Object[DEFAULT_CAPACITY]);
    }
    
    /**
     * Creates a binary tree with the specified element as its root.
     */
    public GenealogyTree (T element)
    {
        result = (T[])(new Object[DEFAULT_CAPACITY]);
        result[0] = element;
    }
    
    /**
     * Returns the element stored in the root (aka CoTU) of the tree.
     */
    public T getCoTU(){
        if (result.length == 0){
        throw new EmptyCollectionException ("Get root operation "
                                            + "failed. The tree is empty.");
                                        }
                                        
        return result[0];
    }
  
    /**
     * Returns the member that is the offspring of target.
     * Returns null as the offspring of the root.
     */
    public T getOffspring(T target){
        if (result.length == 0){
            throw new EmptyCollectionException ("Get root operation "
                                            + "failed. The tree is empty.");
        } 
        
        int index = findTarget(target);
        T offspring = null;
        if(index == 0 || index == -1){
            return offspring;
        }else{
            offspring = result[(int)Math.floor((index-1)/2)];
        }
        return offspring;
    }
  
    /**
     * Returns the member that is the left child of target.
     * Returns null if the left child does not exist.
     */
     public T getPater(T target){
        if (result.length == 0){
            throw new EmptyCollectionException ("Get left child "
                                            + "failed. The tree is empty.");
        }
        
        int index = findTarget(target); 
        
        if ((2*index + 1) == result.length){
            expandCapacity();
        }
        
        if(index == -1 || result[2*index + 1] == null){
            return null;
        }

        return result[2*index + 1];
    }
    
    /**
     * Helper method to find index of target.
     */
    public int findTarget(T target){
        for(int i = 0; i < result.length; i++){
            if(result[i] == target){
                return i;
            }
        }
        return -1;
    }
  
    /**
     *  Helper method. 
     *  Creates a new array to store the contents of this stack with
     *  twice the capacity of the old one.
     */
    private void expandCapacity(){
      T[] larger = (T[])(new Object[result.length*2]);
    
      for (int index = 0; index < result.length; index++)
        larger[index] = result[index];
    
        result = larger;
    }
    
    /**
     * Sets the left child of the tree target to lchild.
     * It throws an exception if target is not already in the tree
     */
    public void setPater(T target, T lchild){
        if (result.length == 0){
            throw new EmptyCollectionException ("Set left child "
                                            + "failed. The tree is empty.");
        }
        
        int index = findTarget(target); 
        
        if ((2*(index + 1)) == result.length){
            expandCapacity();
        }
        
        if(index == -1){
            throw new ElementNotFoundException ("Set left child "
                                       + "failed. No such element in tree.");
        }
        
        result[2*index + 1] = lchild;
    }
  
    /**
     * Returns the element that is the right child of target.
     * Returns null if the right child does not exist.
     */
    public T getMater(T target){
        if (result.length == 0){
            throw new EmptyCollectionException ("Get right child "
                                            + "failed. The tree is empty.");
        }
        
        int index = findTarget(target); 
        if ((2*(index + 1)) == result.length){
            expandCapacity();
        }
        
        if(index == -1 ||result[2*index + 2] == null){
            return null;
        }
        return result[2*index + 2];
    }
        
    /**
     * Sets the right child of target to rchild.
     * It throws an exception if target is not already in the tree.
     */
    public void setMater(T target, T rchild){
        if (result.length == 0){
            throw new EmptyCollectionException ("Set right child "
                                            + "failed. The tree is empty.");
        }
        
        int index = findTarget(target); 
        
        if ((2*(index + 1)) == result.length){
            expandCapacity();
        }
        
        if(index == -1){
            throw new ElementNotFoundException ("Set right child "
                                       + "failed. No such element in tree.");
        }
        
        result[2*index + 2] = rchild;
    }
  
    /**
     * Returns true if the tree contains an element that
     * matches the specified target element and false otherwise.
     */
     public boolean appears (T target){
        if (result.length == 0){
            throw new EmptyCollectionException ("The tree is empty.");
        }
        
        if(findTarget(target) == -1){
            return false;
         }
        
        return true;
    }
    
    /**
     * Returns true if the two members share a grandchild,
     * and false if they are not or if a shared grandchild does not exist
     * Two grandparents that share a grandchild are "inLaws"
     */
    public boolean inLaws(T gp1, T gp2){
        if (result.length == 0){
            throw new EmptyCollectionException ("The tree is empty.");
        }
        
        if(appears (gp1) == false || appears (gp2) == false){
            return false;
        }
        
        return 
         (getOffspring(getOffspring(gp1)) == getOffspring(getOffspring(gp2)));
    }
    
    /**
     * Returns the number of members in this ancestral tree.
     */
    public int size(){
        int count = 0;
        for(int i = 0; i < result.length; i++){
           if(result[i] != null){
               count++;
            }
        }
        return count;
    }
  
    /**
     * Returns the string representation of the binary tree,
     * one line per level.
     */
      public String toString(){
         String result = "";
         Iterator<T> iter = iterator();
         int count = 0;
         int n = 0; // last index of the previous level
         
         result += " $ java MyGenealogy\n" + "The GenealogyTree contains " 
         + size() + " members:\n" + getCoTU() + "\n";
         while(iter.hasNext()){
             T element = iter.next();
                 
             if(getPater(element) != null){
                 result += getPater(element)+ " ";
                 count++;
             }else{
                 continue;
                }
             
             if(getMater(element) != null){
                 result += getMater(element) + " ";
                 count++;
             }else{
                 continue;
                }
             
             if(count == (2*n)+2){
                 result += "\n";
                 n = count;
                }
            }
            return result;
        }
    
    public Iterator<T> iterator(){  
        return byGenerations();
    }
    
    /**
     * Returns an iterator that contains a level-order traversal
     * on the ancestral tree. 
     */
     public Iterator<T> byGenerations(){
        LinkedQueue<T> queue = new LinkedQueue<T>();
        ArrayIterator<T> iter = new ArrayIterator<T>();
        
        if (result[0] != null){
            queue.enqueue(result[0]);
            while (!queue.isEmpty()){
                T current = queue.dequeue();
                iter.add (current);
                
                if (getPater(current) != null)
                    queue.enqueue(getPater(current));
                    
                if (getMater(current) != null)
                    queue.enqueue(getMater(current));
                }
            }
            
        return iter;
    }
    
    public static void main(String[] args){
        GenealogyTree<String> genealogyTree = new GenealogyTree<String>("T");
        genealogyTree.setPater("T", "Y");
        genealogyTree.setMater("T", "E");
        genealogyTree.setPater("Y", "P");
        genealogyTree.setMater("Y", "M");
        genealogyTree.setPater("E", "B");
        genealogyTree.setMater("E", "D");
        genealogyTree.setPater("P", "A");
        genealogyTree.setMater("P", "C");
        genealogyTree.setPater("M", "F");
        genealogyTree.setMater("M", "G");
        genealogyTree.setPater("B", "H");
        genealogyTree.setMater("B", "I");
        genealogyTree.setPater("D", "J");
        genealogyTree.setMater("D", "K");
        System.out.println(genealogyTree.toString());
        
        // Test appears method
        System.out.println("T was found (true): " 
                                + genealogyTree.appears("T"));
        System.out.println("E was found (true): " 
                                + genealogyTree.appears("E"));
        System.out.println("Test edge case - find an element that doesn't exist");
        System.out.println("V was found (false): " 
                                + genealogyTree.appears("V") + "\n");
        
        // Test getOffsping method
        System.out.println("Offspring of Y is (T): " 
                                + genealogyTree.getOffspring("Y"));
        System.out.println("Offspring of D is (E): " 
                                + genealogyTree.getOffspring("D"));
        System.out.println("Edge case - get Offspring of the root");   
        System.out.println("Offspring of T is (null): " 
                                + genealogyTree.getOffspring("T") + "\n");
                                
        // Test getCoTU()
        System.out.println("The root is (T): " 
                                + genealogyTree.getCoTU() + "\n");
        
        // Test getPater and getMater                  
        System.out.println("T's paternal grandfather is (P): " 
                     + genealogyTree.getPater(genealogyTree.getPater("T")));
        System.out.println("T's materal grandfather is (D): " 
                     + genealogyTree.getMater(genealogyTree.getMater("T")));
        System.out.println("T's paternal great-grandfather is (A): " 
         + genealogyTree.getPater(genealogyTree.getPater(genealogyTree.getPater("T"))));            
        System.out.println("T's paternal great-grandfather is (K): " 
         + genealogyTree.getMater(genealogyTree.getMater(genealogyTree.getMater("T"))));   
        System.out.println("Edge case");
        System.out.println("Test getPater() method for unexisted element:");
        System.out.println("Z's grandfather is (null): " 
                   + genealogyTree.getPater(genealogyTree.getPater("Z")));
        System.out.println("Test getMater() method for unexisted element:");
        System.out.println("S's grandfather is (null): " 
                   + genealogyTree.getPater(genealogyTree.getPater("S")) + "\n");
                   
        // Test inLaws
        System.out.println("P and B are in-laws (true): "
                                         + genealogyTree.inLaws("P", "B"));
        System.out.println("P and E are in-laws (false): "
                                         + genealogyTree.inLaws("P", "E"));
        System.out.println("Edge case - Test in-laws() method between one "
           + "exist element and one unexist element");
        System.out.println("S and E are in-laws (false): "
                                    + genealogyTree.inLaws("S", "E"));
        System.out.println("Edge case - Test in-laws() method between two "
           + "unexist element");
        System.out.println("W and Z are in-laws (false): "
                                    + genealogyTree.inLaws("W", "Z"));
                                    
        // Test getCoTU()() for an empty genealogyTree
        GenealogyTree<String> temp = new GenealogyTree<String>();
        System.out.println("Edge case - Test getCoTU()() for an empty genealogyTree");
        System.out.println("The root is (null): " 
                                + temp.getCoTU());
    }
    
}
