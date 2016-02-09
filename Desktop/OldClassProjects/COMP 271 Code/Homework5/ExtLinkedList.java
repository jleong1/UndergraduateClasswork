
/**
 * Write a description of class OddList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

/*  This method builds a new LinkedList with the odd numbered elements from a given LinkedList.  
 * For instance, if the given LinkedList has size 100, starting at location 0 (the head), 
 * and going 1,2,3,..., 99 (the tail), the OddList returns a new LinkedList with elements from
 * 1,3,5,7, .. 99.  If the given list is either empty or a list with just one element, then OddList
 * returns an empty LinkedList.

*/
 /*
  * The run time complexity is O(n) beacause it is necessary to go through the whole length, as a linked list doesn't allow you to skip places,
 *  so all iterations will happen
  */

import java.util.*;

public class ExtLinkedList<E> extends LinkedList<E>
{
    LinkedList<E> n = new LinkedList<E>();
    int size = n.size();
    public ExtLinkedList<E> oddItemsList () {
        ExtLinkedList<E> odd = new ExtLinkedList<E>();
        if(size>1){
            for(int i = 0; i<size; i++){
               if(i % 2 == 1){
                odd.add(n.get(i));
            }
            }
        }
        else{
            return null; 
        }
        return odd;
    }
}