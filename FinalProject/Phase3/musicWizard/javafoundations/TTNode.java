/**
 * TTNode.java <br>
 * Represents a node in a ternary tree with a left, middle, and right child as well as
 * choiceA, choiceB, and choiceC child. <br>
 * 
 * @author Vera Ye
 * @version v2, Dec 11 2018
 */

package javafoundations;

public class TTNode<T> {
    protected T element;
    protected TTNode<T> left, middle, right, choiceA, choiceB, choiceC;

    //-----------------------------------------------------------------
    //  Creates a new tree node with the specified data.
    //-----------------------------------------------------------------
    public TTNode (T element) {
        this.element = element;
        left = middle = right = choiceA = choiceB = choiceC = null;
    }

    //-----------------------------------------------------------------
    //  Returns the element stored in this node.
    //-----------------------------------------------------------------
    public T getElement() {
        return element;
    }

    //-----------------------------------------------------------------
    //  Sets the element stored in this node.
    //-----------------------------------------------------------------
    public void setElement (T element) {
        this.element = element;
    }

    //-----------------------------------------------------------------
    //  Returns the chpiceA subtree of this node.
    //-----------------------------------------------------------------
    public TTNode<T> getChoiceA() {
        return choiceA;
    }

    //-----------------------------------------------------------------
    //  Sets the choiceA child of this node.
    //-----------------------------------------------------------------
    public void setChoiceA (TTNode<T> choiceA) {
        this.choiceA = choiceA;
    }

    //-----------------------------------------------------------------
    //  Returns the choiceB subtree of this node.
    //-----------------------------------------------------------------
    public TTNode<T> getChoiceB() {
        return choiceB;
    }

    //-----------------------------------------------------------------
    //  Sets the choiceB child of this node.
    //-----------------------------------------------------------------
    public void setChoiceB (TTNode<T> choiceB) {
        this.choiceB = choiceB;
    }

    //-----------------------------------------------------------------
    //  Returns the choiceC subtree of this node.
    //-----------------------------------------------------------------
    public TTNode<T> getChoiceC() {
        return choiceC;
    }

    //-----------------------------------------------------------------
    //  Sets the choiceC child of this node.
    //-----------------------------------------------------------------
    public void setChoiceC (TTNode<T> choiceC) {
        this.choiceC = choiceC;
    }

    //-----------------------------------------------------------------
    //  Returns the left subtree of this node.
    //-----------------------------------------------------------------
    public TTNode<T> getLeft() {
        return left;
    }

    //-----------------------------------------------------------------
    //  Sets the left child of this node.
    //-----------------------------------------------------------------
    public void setLeft (TTNode<T> left) {
        this.left = left;
    }

    //-----------------------------------------------------------------
    //  Returns the middle subtree of this node.
    //-----------------------------------------------------------------
    public TTNode<T> getMiddle() {
        return middle;
    }

    //-----------------------------------------------------------------
    //  Sets the middle child of this node.
    //-----------------------------------------------------------------
    public void setMiddle (TTNode<T> middle) {
        this.middle = middle;
    }

    //-----------------------------------------------------------------
    //  Returns the right subtree of this node.
    //-----------------------------------------------------------------
    public TTNode<T> getRight() {
        return right;
    }

    //-----------------------------------------------------------------
    //  Sets the right child of this node.
    //-----------------------------------------------------------------
    public void setRight (TTNode<T> right) {
        this.right = right;
    }

    //-----------------------------------------------------------------
    //  Returns the element in this subtree that matches the
    //  specified target. Returns null if the target is not found.
    //-----------------------------------------------------------------
    public TTNode<T> find (T target) {
        TTNode<T> result = null;

        if (element.equals(target)) {
            result = this;
        } else {
            if (left != null)
                result = left.find(target);

            if (result == null && middle != null)
                result = middle.find(target);

            if (result == null && right != null)
                result = right.find(target);
        }

        return result;
    }

    //-----------------------------------------------------------------
    //  Returns the number of nodes in this subtree.
    //-----------------------------------------------------------------
    public int count() {
        int result = 1;

        if (left != null)
            result += left.count();

        if (middle != null)
            result += middle.count();

        if (right != null)
            result += right.count();

        return result;
    }

    //-----------------------------------------------------------------
    //  Performs an preorder traversal on this subtree, updating the
    //  specified iterator.
    //-----------------------------------------------------------------
    public void preorder (ArrayIterator<T> iter) {
        iter.add (element);

        if (left != null)
            left.preorder (iter);

        if (middle != null)
            middle.preorder (iter);

        if (right != null)
            right.preorder (iter);
    }

    //-----------------------------------------------------------------
    //  Performs an inorder traversal on this subtree, updating the
    //  specified iterator.
    //-----------------------------------------------------------------
    public void inorder (ArrayIterator<T> iter) {
        if (left != null)
            left.inorder (iter);

        iter.add (element);

        if (middle != null)
            middle.inorder (iter);

        if (right != null)
            right.inorder (iter);
    }

    //-----------------------------------------------------------------
    //  Performs an postorder traversal on this subtree, updating the
    //  specified iterator.
    //-----------------------------------------------------------------
    public void postorder (ArrayIterator<T> iter) {
        if (left != null)
            left.postorder (iter);

        if (middle != null)
            middle.postorder (iter);

        if (right != null)
            right.postorder (iter);

        iter.add (element);
    }

    // Returns the height of this subtree.
    public int height() {
        int l = 0;
        int m = 0;
        int r = 0;

        if (left == null && middle == null && right == null) {
            return 0; //only one node indicates that the height is zero
        }

        if (left != null)
            l = left.height();

        if (middle != null)
            m = middle.height();

        if (right != null)
            r = right.height();

        return Math.max(Math.max(l, m), r) + 1;
    }

    // Performs a spin action. 
    public void spin(){
        TTNode<T> temp = left;
        left = middle;
        middle = right;
        right = temp;

        if (left != null)
            left.spin();
        if (middle != null)
            middle.spin();
        if (right != null)
            right.spin();
    }

    // A main class used for testing purpose
    public static void main(String[] args) {
        // testing
        TTNode<String> one = new TTNode<String>("one");
        TTNode<String> two = new TTNode<String>("two");
        TTNode<String> three = new TTNode<String>("three");
        TTNode<String> four = new TTNode<String>("four");
    }
}
