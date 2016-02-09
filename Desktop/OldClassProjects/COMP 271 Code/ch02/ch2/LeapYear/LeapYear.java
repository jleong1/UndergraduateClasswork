import java.util.*;  // for the Scanner class

public class LeapYear
{
    
    public static void main (String args [ ]) 
     {     
         new LeapYear().run(); 
     } // method main 


     public void run()
     {           
         final String INPUT_PROMPT = "Please enter the year: ";
         
         Scanner sc = new Scanner (System.in);         
            
         for (int i = 0; i < 5; i++)
             try
             {    
                 System.out.print (INPUT_PROMPT);
                 System.out.println (isLeapYear (sc));                 
             } // try
             catch (InputMismatchException e)
             {                 
                 System.out.println ("The input is not an integer.");
                 sc.nextLine();
             } // catch InputMismatchException   
     } // method run
     

     public boolean isLeapYear (Scanner sc)
     {             
           final int FIRST_YEAR = 1582; // start of Gregorian Calendar

           int year = sc.nextInt(); 
         
           if (year < FIRST_YEAR)
             throw new IllegalArgumentException();
         
           if ((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0))
             return true;
           return false;       
     } // method isLeapYear     
     
} // class LeapYear
