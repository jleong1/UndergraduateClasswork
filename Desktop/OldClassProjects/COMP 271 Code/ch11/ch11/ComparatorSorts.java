import java.util.*;

public class ComparatorSorts
{  
  
   /**
    *  Sorts a specified array into the order specified by a specified Comparator
    *  object.
    *  The worstTime(n) is O(n * n).
    *
    *  @param x – the array to be sorted.
    *  @param comp – the Comparator object used for ordering.
    *
    *  @throws NullPointerException - if x and/or comp is null.
    * 
    */
   public static <T> void insertionSort (T [ ] x, Comparator<T> comp) 
   {
      for (int i = 1; i < x.length; i++)
         for (int k = i; k > 0 && (comp.compare (x [k -1],x [k]) > 0); k--)
             swap (x, k, k -1);
   } // method insertionSort
  
  
   /**
    *  Sorts a specified array into the order specified by a specified Comparator
    *  object.
    *  The worstTime(n) is O(n * n).
    *
    *  @param x – the array to be sorted.
    *  @param comp – the Comparator object used for ordering.
    *
    *  @throws NullPointerException - if x and/or comp is null.
    * 
    */
   public static <T> void selectionSort (T [ ] x, Comparator<T> comp) 
   {
      // Make x [0] ... x[i] sorted and <= x [i + 1] ... x [x.length - 1]:
      for (int i = 0; i < (x.length - 1); i++) 
      {
         int pos = i;
         for (int k = i + 1; k < x.length; k++)
            if (comp.compare (x [k], x [pos]) < 0)  
                pos = k;
        swap (x, i, pos);
      } // for i
   } // method selectionSort
  
  
  
  /**
   *  Sorts a specified array into the order specified by a specified Comparator
   *  object.
   *  The worstTime(n) is O(n * n).
   *
   *  @param x – the array to be sorted.
   *  @param comp – the Comparator object used for ordering.
   *
   *  @throws NullPointerException - if x and/or comp is null.
   * 
   */
   public static <T> void bubbleSort (T [ ] x, Comparator<T> comp) 
   {
      int finalSwapPos = x.length - 1,
            swapPos;              
    
      while (finalSwapPos > 0)
      {
         swapPos = 0;
         for (int i = 0; i < finalSwapPos; i++)
           if (comp.compare (x [i], x [i + 1]) > 0) 
          {
            swap (x, i, i + 1);
            swapPos = i;
          } // if
         finalSwapPos = swapPos;             
      } // while      
   } // method bubbleSort   
  
   /**  Swaps two specified elements in a specified array.
    *
    *  @param x – the array in which the two elements are to be swapped.
    *  @param a – the index of one of the elements to be swapped.
    *  @param b – the index of the other element to be swapped.
    *
    */
   public static void swap (Object [] x, int a, int b) 
   {
      Object t = x[a];
      x[a] = x[b];
      x[b] = t;
   } // method swap
  
}//class ComparatorSorts

class ByLength implements Comparator<String> 
 {
     /** 
      *  Compares two specified String objects lexicographically if they have the 
      *  same length, and otherwise returns the difference in their lengths.
      *
      *  @param s1 – one of the specified String objects.
      *  @param s2 – the other specified String object.
      *
      *  @return s1.compareTo (s2) if s1 and s2 have the same length; 
      *                otherwise, return s1.length() – s2.length(). 
      *
      *  @throws NullPointerException - if s1 and/or s2 is null.
      * 
      */ 
     public int compare (String s1, String s2) 
     {
          int len1 = s1.length(),
              len2 = s2.length();
          if (len1 == len2)
               return s1.compareTo (s2);
          return len1 - len2;
     } // method compare

} // class ByLength

class Decreasing implements Comparator<Integer> 
 {
  /**
   *  Compares two specified Integer objects. 
   *
   *  @param i1 – one of the Integer objects to be compared.
   *  @param i2 – the other Integer object.
   *
   *  @return the value of i2’s int – the value of i1’s int.
   *
   */
      public int compare (Integer i1, Integer i2) 
  {
           return i2.compareTo (i1);
      } // method compare

 } // class Decreasing


