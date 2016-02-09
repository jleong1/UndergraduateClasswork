public class Scope
{
   boolean t = true;
   
   int x = 99;
   
   double sample = 8.1;
   
   public static void main (String[] args)
   {
      new Scope().sample (7);
      new Scope().original();
   } // method main
     
   public void sample (double x)
   {
       double y = 5;
       
       x = 5.3;       
       for (int t = 0; t < 3; t++)
       { 
          int i = t + 4;
          
          System.out.println (i + t + x);
       } // end of int t's scope; end of i's scope     

       for (int t = 0; t < 7; t++)
           x = t;   // end of the scope of this version of int t     
   }  // method sample; end of double x's scope; end of y's scope

   public void original()
   {
       System.out.println (t + " " + x + " " + sample);
   } // method original
   
} // class Scope; end of boolean t's scope; end of int x's scope; end of double sample's scope
