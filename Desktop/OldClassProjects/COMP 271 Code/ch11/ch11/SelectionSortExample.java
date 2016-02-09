import java.util.*;  // for the Comparator interface

public class SelectionSortExample
{
    public static void main(String[] args)
    {
        new SelectionSortExample().run();
    } // method main

    public void run()
    {
        String[ ] words = {"Jayden", "Jack", "Rowan", "Brooke"};
  
        selectionSort (words, new ByLength());
        for (String s : words)
            System.out.print (s + "  ");
   } // method run

    /**
     *  Sorts a specified array into the order specified by a specified Comparator
     *  object.
     *  The worstTime(n) is O(n * n).
     *
     *  @param x – the array to be sorted.
     *  @param comp – the Comparator object used for ordering.
     *
     */
    public static <T> void selectionSort (T [ ] x, Comparator<T> comp) 
    {
        // Make x [0 … i] sorted and <= x [i + 1] …x [x.length – 1]:
        for (int i = 0; i < x.length - 1; i++) 
        {
             int pos = i;
             for (int k = i + 1; k < x.length; k++)
                 if (comp.compare (x [k], x [pos]) < 0) 
                      pos = k;
             swap (x, i, pos);             
        } // for i
    } // method selectionSort
 
    public static void swap (Object[ ] x, int a, int b)
    {
        Object temp = x [a];
        x [a] = x [b];
        x [b] = temp;
    } // swap

} // class SelectionSortExample

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


