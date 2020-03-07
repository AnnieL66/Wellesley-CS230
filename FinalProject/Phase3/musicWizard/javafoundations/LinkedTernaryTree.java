package javafoundations;

/**
 * LinkedTernaryTree.java <br>
 * Implements a ternary tree using a linked representation. <br>
 *
 * @author Yaxin Liu
 * @version v2, Dec 11 2018
 */

import java.util.*;
import javafoundations.*;
import javafoundations.exceptions.*;

public class LinkedTernaryTree<T> implements TernaryTree<T> {
    
    protected TTNode<T> root;

    /**
     * Constructor for objects of class LinkedTernaryTree
     */
    public LinkedTernaryTree() {
        root = null;
    }

    /**
     * Creates a ternary tree with the specified element as its root.
     */
    public LinkedTernaryTree (T element) {
        root = new TTNode<T>(element);
    }
  
    /**
     * Creates a ternary tree with the three specified subtrees.
     */
    public LinkedTernaryTree (T element, LinkedTernaryTree<T> left,
            LinkedTernaryTree<T> middle, LinkedTernaryTree<T> right, 
            LinkedTernaryTree<T> choiceA,LinkedTernaryTree<T> choiceB,
            LinkedTernaryTree<T> choiceC) {
        root = new TTNode<T>(element);
        root.setLeft(left.root);
        root.setMiddle(middle.root);
        root.setRight(right.root);
        root.setChoiceA(choiceA.root);
        root.setChoiceB(choiceB.root);
        root.setChoiceC(choiceC.root);
    }
    
    /**
     * Returns the element stored in the root of the tree. Throws an
     * EmptyCollectionException if the tree is empty.
     */
    public T getRootElement(){
        if (root == null){
            throw new EmptyCollectionException ("Get root operation "
                                            + "failed. The tree is empty.");
        }
    
        return root.getElement();
    }
    
    /**
     * Returns the left subtree of the root of this tree.
     */
    public LinkedTernaryTree<T> getLeft(){
        if (root == null){
            throw new EmptyCollectionException ("Get left operation "
                                            + "failed. The tree is empty.");
        }
        
        LinkedTernaryTree<T> result = new LinkedTernaryTree<T>();
        result.root = root.getLeft();
        
        return result;
    }
  
    /**
     * Returns the middle subtree of the root.
     */
    public LinkedTernaryTree<T> getMiddle() {
        if (root == null){
            throw new EmptyCollectionException ("Get middle operation "
                                            + "failed. The tree is empty.");
        }
        
        LinkedTernaryTree<T> result = new LinkedTernaryTree<T>();
        result.root = root.getMiddle();
        
        return result;
    }
    
    /**
     * Returns the right subtree of the root.
     */
    public LinkedTernaryTree<T> getRight(){
        if (root == null){
            throw new EmptyCollectionException ("Get right operation "
                                            + "failed. The tree is empty.");
        }
        
        LinkedTernaryTree<T> result = new LinkedTernaryTree<T>();
        result.root = root.getRight();
        
        return result;
    }
    
    /**
     * Returns the choiceA subtree of the root of this tree.
     */
    public LinkedTernaryTree<T> getChoiceA(){
        if (root == null){
            throw new EmptyCollectionException ("Get ChoiceA operation "
                                            + "failed. The tree is empty.");
        }
        
        LinkedTernaryTree<T> result = new LinkedTernaryTree<T>();
        result.root = root.getChoiceA();
        
        return result;
    }
    
    /**
     * Returns the choiceB subtree of the root of this tree.
     */
    public LinkedTernaryTree<T> getChoiceB(){
        if (root == null){
            throw new EmptyCollectionException ("Get ChoiceB operation "
                                            + "failed. The tree is empty.");
        }
        
        LinkedTernaryTree<T> result = new LinkedTernaryTree<T>();
        result.root = root.getChoiceB();
        
        return result;
    }
    
    /**
     * Returns the choiceC subtree of the root of this tree.
     */
    public LinkedTernaryTree<T> getChoiceC(){
        if (root == null){
            throw new EmptyCollectionException ("Get ChoiceA operation "
                                            + "failed. The tree is empty.");
        }
        
        LinkedTernaryTree<T> result = new LinkedTernaryTree<T>();
        result.root = root.getChoiceC();
        
        return result;
    }
    
    /**
     * Returns true if the ternary tree contains an element that
     * matches the specified element and false otherwise.
     */
    public boolean contains (T target){
        try{
            find(target);
        } catch(ElementNotFoundException enfe){
            return false;
        }
    
        return true;
    }
    
    /**
     * Returns the element in this ternary tree that matches the
     * specified target. Throws a ElementNotFoundException if the
     * target is not found.
     */
    public T find (T target){
        TTNode<T> node = null;
    
        if (root != null){
            node = root.find(target);
        }
        
        if (node == null){
            throw new ElementNotFoundException("Find operation failed. "
                                           + "No such element in tree.");
        }
        
        return node.getElement();
    }
    
    /**
     * Returns true if the ternary tree contains no elements, and
     * false otherwise.
     */
    public boolean isEmpty(){
        return size() == 0;
    }
  
    /**
     * Returns the number of elements in this ternary tree.
     */
    public int size(){
        int result = 0;
    
        if (root != null){
            result = root.count();
        }
    
        return result;
    }
    
    /**
     * Returns the string representation of the ternary tree.
     */
    public String toString(){
        String result = "";
        Iterator<T> iter = iterator();
        while(iter.hasNext()){
            result += iter.next() + "\n";
        }
        return result;
    }
  
    /**
     * Satisfies the Iterable interface using an inorder traversal.
     */
    public Iterator<T> iterator(){
        return inorder();
    }

    /**
     * Populates and returns an iterator containing the elements in
     * this ternary tree using an preorder traversal.
     */
    public Iterator<T> preorder(){
        ArrayIterator<T> iter = new ArrayIterator<T>();
    
        if (root != null){
            root.preorder (iter);
        }
    
        return iter;
    }
    
    /**
     * Populates and returns an iterator containing the elements in
     * this ternary tree using an inorder traversal.
     */
    public Iterator<T> inorder(){
        ArrayIterator<T> iter = new ArrayIterator<T>();
    
        if (root != null){
            root.inorder (iter);
        }
    
        return iter;
    }
    
    /**
     * Populates and returns an iterator containing the elements in
     * this ternary tree using an postorder traversal.
     */
    public Iterator<T> postorder(){
         ArrayIterator<T> iter = new ArrayIterator<T>();
    
         if (root != null){
             root.postorder (iter);
         }
    
         return iter;
    }
  
    /**
     * Populates and returns an iterator containing the elements in
     * this ternary tree using an levelorder traversal.
     */
    public Iterator<T> levelorder(){
        LinkedQueue<TTNode<T>> queue = new LinkedQueue<TTNode<T>>();
        ArrayIterator<T> iter = new ArrayIterator<T>();
    
        if (root != null){
            queue.enqueue(root);
            while (!queue.isEmpty()){
                TTNode<T> current = queue.dequeue();
                
                iter.add (current.getElement());
                
                if (current.getLeft() != null){
                    queue.enqueue(current.getLeft());
                }
                
                if (current.getMiddle() != null){
                    queue.enqueue(current.getMiddle());
                }
                
                if (current.getRight() != null){
                    queue.enqueue(current.getRight());
                }
            }
        }
        
        return iter;
    }
}
