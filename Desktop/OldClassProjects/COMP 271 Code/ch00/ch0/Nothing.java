public class Nothing
{  
   public static void main (String[ ] args) 
   {  
     new Nothing().run();
   } // method main

   public void run()
   {  
      int k = 30;
                   
      triple (k);
    
      System.out.println (k);
   } // method run

   public void triple (int n)
   {
        n = n * 3;
   } // method triple

} // class Nothing
