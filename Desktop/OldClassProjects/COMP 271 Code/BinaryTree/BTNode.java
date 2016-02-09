
/**
 * Write a description of class BTNode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * */
   public class BTNode<E>
  {
    protected E element;
    protected BTNode<E> left;
    protected BTNode<E> right;
    protected BTNode<E> parent;
    
    
    public BTNode()
    {
        element=null;
        left=null;
        right=null;
        parent=null;
    }
    public BTNode(E val, BTNode<E> l, BTNode<E> r, BTNode<E> p) {
        
        
        element=val;
        left=l;
        right=r;
        parent=p;
    }
        
        
    
    
    
    public void setElement(E value)
    {
        element=value;
    }
    public void setLeft (BTNode<E> l)
    {
        left=l;
    }
    
   public void setRight(BTNode<E> r)
   {
       right=r;
    }
    
    public E getElement()
    {
    return element;
    }

   public BTNode<E> getLeft() {
    return left;
    }
    public BTNode<E> getRight (){
        return right;
    }


    
    
  } // class Entry
