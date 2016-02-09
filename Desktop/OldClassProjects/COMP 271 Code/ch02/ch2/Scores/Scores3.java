import java.util.*;

import java.io.*;

public class Scores3 
{
    public static void main (String [ ] args) 
    {    
        new Scores3().run();         
    } // method main


    public void run()
    {
        final String IN_FILE_PROMPT = 
            "\nPlease enter the name of the input file: ";
       
        final String OUT_FILE_PROMPT = 
            "\nPlease enter the name of the output file: ";
               
        final String RESULT = "\n\nThe sum of the scores is ";
        
        Scanner keyboardScanner = new Scanner (System.in),
                      fileScanner;

        PrintWriter printWriter = null;  // to ensure that printWriter has been initialized
                                         // before it is closed in the finally block

        int sum = 0;

        try
        {            
            while (true)
            {
                try
                {
                    System.out.print (IN_FILE_PROMPT);
                    fileScanner = new Scanner (new File (keyboardScanner.nextLine())); 
                    
                    System.out.print (OUT_FILE_PROMPT);
                    printWriter = new PrintWriter (new BufferedWriter
                                      (new FileWriter (keyboardScanner.nextLine())));
                                                          
                    sum = addScores (fileScanner, printWriter);                                  
                    break;                            
                } // try
                catch (IOException e)
                {
                    System.out.println (e);
                } // catch    
            } // while files not OK
        } // try
        catch (NumberFormatException e)
        {
          System.out.println (e);
        } // catch NumberFormatException
        finally
        {     
            printWriter.println (RESULT + sum);
            printWriter.close();
        } // finally 
    }  // method run

     /**
      *  Returns the sum of the scores scanned in.
      *        
      *  @param fileScanner – the Scanner object from which the scores are scanned
      *  @param printWriter – the PrintWriter object to which the scores are written.
      *                       If a score generates InputMismatchException, the message
      *                       "java.util.InputMismatchException: " precedes the score.     
      *       
      *  @return the sum of the scores scanned in from fileScanner.
      * 
      *  @throws NumberFormatException – if the values scanned in do not include
      *                                                             an integer. 
      *
      */
    public int addScores (Scanner fileScanner, PrintWriter printWriter) 
    {
        final String NO_LEGAL_SCORES_MESSAGE =
            "The input contains no legal scores.";
             
        int score,
            sum = 0;
        
        boolean atLeastOneScore = false;
                                            
        while (fileScanner.hasNext())
        {
            try
            {      
                score = fileScanner.nextInt();                        
                printWriter.println (score);                       
                sum += score;
                atLeastOneScore = true;
            } // try 
            catch (InputMismatchException e)
            {
                printWriter.println (e + ": " + fileScanner.nextLine());
            } // catch InputMismatchException   
        } // while more scores in input file
        if (!atLeastOneScore)
            throw new NumberFormatException (NO_LEGAL_SCORES_MESSAGE);       
        return sum;
    } // method addScores    
    
} // class Scores3
