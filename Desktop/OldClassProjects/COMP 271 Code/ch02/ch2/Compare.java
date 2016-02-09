public class Compare
{    
  public static void main (String[ ] args) 
   {  
       new Compare().run();  
  } // method main

  public void run()
  {
       System.out.println (smaller (5.00, 4.00));
       System.out.println (smaller (5.00, 20.00));           
  } // method run
 
  public double smaller (double price1, double price2)
  {
         if (Math.abs (price1 - price2) > Math.min (price1, price2))
                // throw new ArithmeticException ("difference too large");
                throw new UnreasonablenessException ("difference too large"); 
        return Math.min (price1, price2);
  } // method smaller

} // class Compare
