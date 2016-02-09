
/**
 * Write a description of class LL here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
/*
 *  The run time complexity is O(n) beacause it is necessary to go through the whole length, as a linked list doesn't allow you to skip places,
 *  so all iterations will happen
 */
public class LList <E> 
{
  Entry<E> head;
  Entry<E> tail;

  int size;
  
  public LList() {
       size=0;
       head=null;
       tail=null;
      
    }
    
    public void add(E value) {
        
        if (size==0) 
        {
            head = new Entry<E>(value);
            tail= head;
            
        }
        else
        { 
            Entry <E> p= new Entry<E>(value,null,tail);
            tail.next=p;
            tail=p;
        }
        size++;
            
        
    }

//returns the element E found at location i
//provided 0<=i<size otherwise returns null and print an 
//appropriate error message
    public E get (int i)

    { 
     Entry<E> p = new Entry<E> (null, head);
    if (0<=i && i<size){
        for(int j = 0;j<=i;j++){
        p = p.next;
       }
    }
    else{
        System.out.println("Index does not exist");
        return null;
    }
    return p.element;
   }

// inserts a new node at the beginning of the linkedlist and 
//head needs to reference this after insertion

public void addFirst (E value) {
    Entry<E> p = new Entry<E>(value,head,null);
    head.prev = p;
    head = p;
    size++;
}

// adds a new node at the end of the LinkedList after current 
//tail.  After insertion tail should 
//reference this new node.

public void addLast (E value) {
       Entry <E> p= new Entry<E>(value,null,tail);
       tail.next=p;
       tail=p;
       size++;
}

// removes a node at index i returning the element value in it. 
//Make sure, 0<=i<size, otherwise  print an
 //appropriate error message and return null.


public E remove (int i) {
    Entry<E> p = new Entry<E> (null,head);
    if(0<=i && i<size){
        for(int j = 0; j<=i;j++){
            if(j==i){
             p.next = p;
             head.next = p;
            }
        }
    }
    else{
        System.out.println("Index does not exist");
        return null;
    }
    size--;
    return p.element;
}

//Print all the values in the LinkedList starting from beginning 
//to end.  If list is empty, print an error message.
public void printList() {
    Entry<E> p = new Entry<E> (null,head);
   if(size==0){
       System.out.println("Error, empty linked list");
    }
    else{
    for(int i = 0; i<size;i++)
    {
        p = p.next;
        System.out.println(p.element);
    }
    }
}
}    

