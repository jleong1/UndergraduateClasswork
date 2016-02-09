public class Btree<E>
{
    // instance variables - replace the example below with your own
    private int size;
    private BTNode<E> root;
    /**
     * Constructor for objects of class Btree
     */
    public Btree()
    {
       
        size=0;
        root=null;
    }
    public Btree(E val) {
        size=1;
        root= new BTNode<E>(val,null,null,null);
        
    }
    public BTNode<E>  addLeft(BTNode<E> p, E val) {
        BTNode<E> temp = new BTNode<E>(val,null,null,p);
        p.left=temp;
        size++;
        return temp;
        
        
    }
    public BTNode<E> addRight(BTNode<E> p, E val) {
        BTNode<E> temp = new BTNode<E>(val,null,null,p);
        p.right=temp;
        size++;
        return temp;
    }
    
    public static void main (String[] args)
    {
        Btree<Integer> bt = new Btree<Integer>(15);
        BTNode<Integer> n1 = bt.addLeft(bt.root, 20);
        BTNode<Integer> n2 = bt.addRight(bt.root, 25);
        BTNode<Integer> n3 = bt.addLeft(bt.root, 10);
        BTNode<Integer> n4 = bt.addRight(bt.root, 5);
       
          
          
        }
        }