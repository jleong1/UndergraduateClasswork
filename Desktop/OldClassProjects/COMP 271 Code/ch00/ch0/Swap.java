public class Swap
{  
   public static void main (String[ ] args) 
   {    
     new Swap().run();
   } // method main

   public void run()
   {
      double[ ] x = {5.0, 8.0, 12.2, 20.0};
                   
      swap (x, 1, 2);
    
      System.out.println (x [1] + " " + x [2]);
   } // method run

   public void swap (double[ ] a, int i, int j)
   {
      double temp = a [i];
      a [i] = a [j];
      a [j] = temp;
   } // method swap

} // class Swap
