public class PrimeTester
{
   public static void main (String[] args)
   {
       new PrimeTester().run();
   } // method main
   
   public void run()
   {
     int k;
          
     boolean flag = true;

//     if (flag)
//       k = 20;
//     if (!flag)
//       k = 21;
     if (flag)
       k = 20;
     else
       k = 21;
     System.out.println (isPrime (k));
   } // method run

   /**
    *  Determines if a specified integer greater than 1 is prime.
    *  
    *  @param n – the integer whose primality is being tested.
    *
    *  @return true – if n is prime.
    *
    */
   public static boolean isPrime (int n)
   {
     if (n == 2)
       return true;
     if (n % 2 == 0)
       return false;
     for (int j = 3; j * j <= n; j = j + 2)
       if (n % j == 0)
          return false;
     return true;
   } // method isPrime
   
} // class PrimeTester

