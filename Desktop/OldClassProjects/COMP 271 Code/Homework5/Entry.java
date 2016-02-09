
/**
 * Write a description of class Entry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Entry <E>
{
  E element;
  Entry<E> prev;
  Entry<E> next;
  
  public Entry() {
      element=null;
      prev=null;
      next=null;
    }
    
    public Entry(E info) {
        element =info;
        prev=null;
        next=null;
    }
    
    public Entry (E info, Entry <E> n){
        element=info;
        prev=null;
        next=n;
    }
    public Entry (E info, Entry<E> n, Entry <E> p) {
        element=info;
        prev=p;
        next=n;
    }


}
