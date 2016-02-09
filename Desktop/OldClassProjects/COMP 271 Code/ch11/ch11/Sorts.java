import java.util.*;

public class Sorts
{  
  
   /**
    *  Sorts a specified array of int values into ascending order.
    *  The worstTime(n) is O(n * n).
    *
    *  @param x – the array to be sorted. 
    * 
    *  @throws NullPointerException - if x is null.
    *
    */ 
   public static void insertionSort (int[ ] x) 
   {
        for (int i = 1; i < x.length; i++)
            for (int k = i; k > 0 && x [k -1] > x [k]; k--)
        swap (x, k, k -1);
   } // method insertionSort

  
  
   /**
    *  Sorts a specified array of int values into ascending order.
    *  The worstTime(n) is O(n * n).
    *
    *  @param x – the array to be sorted. 
    * 
    *  @throws NullPointerException - if x is null.
    *
    */ 
   public static void selectionSort (int [ ] x) 
   {
        // Make x [0 … i] sorted and <= x [i + 1] …x [x.length – 1]:
        for (int i = 0; i < x.length - 1; i++) 
        {
             int pos = i;
             for (int k = i + 1; k < x.length; k++)
                 if (x [k] < x [pos]) 
                      pos = k;
             swap (x, i, pos);             
        } // for i
   } // method selectionSort

  
  
   /**
    *  Sorts a specified array of int values into ascending order.
    *  The worstTime(n) is O(n * n).
    *
    *  @param x – the array to be sorted. 
    * 
    *  @throws NullPointerException - if x is null.
    *
    */ 
   public static void bubbleSort (int[ ] x) 
   {
          int finalSwapPos = x.length - 1,
              swapPos;              

          while (finalSwapPos > 0)
          {
               swapPos = 0;
               for (int i = 0; i < finalSwapPos; i++)
                    if (x [i] > x [i + 1])
                    {
                         swap (x, i, i + 1);
                         swapPos = i;
                    } // if
               finalSwapPos = swapPos;             
          } // while      
   } // method bubbleSort



    /**
     *  Sorts a specified int array into ascending order.
     *  The worstTime(n) is O(n log N), where n is the length of the array, and N is the largest
     *  number (in absolute value) of the numbers in the array.
     *
     *  @param a  the array to be sorted.
     *
     *  @throws NullPointerException - if a is null.
     *
     */
    public static void radixSort (int [ ] a) 
    {
        final int RADIX = 10;

        int biggest = a [0],
            i;
                

        for (i = 1; i < a.length; i++)
            if (a [i] > biggest)
                 biggest = a [i];

        int maxDigits = (int)Math.floor (Math.log (biggest) / Math.log (10)) + 1;

        long quotient = 1;            // the type is long because the largest 
                                      // number may have
                                      // 10 digits; the successive 
                                      // quotients are 1, 10, 100, 1000,
         // and so on.  10 to the 10th is too 
      // large for an int value.

        LinkedList[ ] lists = new LinkedList [RADIX];

        for (int m = 0; m < RADIX; m++)
            lists [m] = new LinkedList<Integer>();

        // Loop once for each digit in the largest number:
        for (int k = 0; k < maxDigits; k++) 
       {
            // Store each int in a as an Integer in lists at the index of 
            // a [i]'s kth-smallest digit:
            for (i = 0; i < a.length; i++)
                 ((LinkedList<Integer>)lists [(int)(a [i] / quotient) % RADIX]).add (a [i]);
            i = 0;

            // Store each Integer in list [0], list [1],... , as an int in a:
            for (int j = 0; j < RADIX; j++) 
            {
                 for (Integer anInt : (LinkedList<Integer>)lists [j])
                        a [i++] = anInt.intValue();  
                 lists [j].clear();
            } // for j
            quotient *= RADIX;
        } // for k
   } // method radixSort

  
  
   /**
    *  Swaps two specified elements in a specified array.
    *
    *  @param x – the array in which the two elements are to be swapped.
    *  @param a – the index of one of the elements to be swapped.
    *  @param b – the index of the other element to be swapped.
    *
    */
    public static void swap (int [ ] x, int a, int b) 
    {
      int t = x[a];
      x[a] = x[b];
      x[b] = t;
    } // method swap

  
}//class Sorts
