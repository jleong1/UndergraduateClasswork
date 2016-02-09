import java.util.*;

public class  TreeSetExample
{   
    public static void main (String[ ] args) 
    {
        new TreeSetExample().run();
    } // method main

    public void run()
    {
         final String START = "Here is the TreeSet:\n";

         final String ADD =
             "\nAfter adding \"tranquil\", here is the TreeSet:\n";

         final String REMOVE =
             "\nAfter removing \"serene\", here is the TreeSet:\n";

         final String REVERSE =
             "\n\nHere are the scores in decreasing order:\n";

         final String SUM = "The sum of the scores is ";
         
         TreeSet<String> mySet = new TreeSet<String>();

         TreeSet<Integer> scores = new TreeSet<Integer>(new Decreasing ());

         mySet.add ("happy");
         mySet.add ("always");
         mySet.add ("yes");
         mySet.add ("serene");
         System.out.println (START + mySet);

         if (mySet.add ("happy"))
             System.out.println ("ooops");
         else
             System.out.println ("\n\"happy\" was not added " +
                                 "because it was already there");
             mySet.add ("tranquil");
             System.out.println (ADD + mySet);
             System.out.println ("size = " + mySet.size());
             if (mySet.contains ("no"))
                  System.out.println ("How did \"no\" get in there?");
             else
                  System.out.println ("\n\"no\" is not in the TreeSet");
             if (mySet.remove ("serene"))
                  System.out.println (REMOVE + mySet);

             for (int i = 0; i < 5; i++)
                  scores.add (i);
             System.out.println (REVERSE + scores);

             int sum = 0;
                                 
             for (Integer i : scores)
                 sum += i;                      
             System.out.println (SUM + sum);
      } // method run

} // class TreeSetExample

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

