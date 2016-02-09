import java.util.*;  

import java.io.*;

public class LeapYearFile
{
    
    public static void main (String args [ ]) 
     {
         new LeapYearFile().run(); 
     } // method main 


    public void run()
    {   
         final String INPUT_PROMPT = "Please enter the file name: ";
         
         Scanner keyboardScanner = new Scanner (System.in);
         
         String fileName;
         
         while (true)
         {
             System.out.print (INPUT_PROMPT);
             fileName = keyboardScanner.next();
             try
             {
                 Scanner sc = new Scanner (new File (fileName));         
            
                 while (sc.hasNext())
                     try
                     {                    
                         System.out.println (isLeapYear (sc));                 
                     } // try to scan a year
                     catch (InputMismatchException e)
                     {                 
                         System.out.println ("The input is not an integer.");
                         sc.nextLine();
                     } // catch input mismatch
                 break; 
             } // try to scan the name of an existing file
             catch (FileNotFoundException e) 
             { 
                 System.out.println (e);
             } // catch file not found
         } // while true
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
