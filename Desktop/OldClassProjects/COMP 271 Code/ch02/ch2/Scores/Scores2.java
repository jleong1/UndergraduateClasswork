import java.util.*;

import java.io.*;

public class Scores2 
{
    public final int SENTINEL = -1;
         
    public static void main (String [ ] args)
    {        
        new Scores2().run();        
    } // method main


    public void run()
    {       
        final String INPUT_PROMPT = 
            "\nOn each line, enter a test score (or " + SENTINEL + " to quit): ";

        PrintWriter printWriter = null; // to ensure that printWriter is initialized 
                                        // before it is closed in the finally block       
        try
        {      
            Scanner sc = new Scanner (System.in);             
            printWriter = new PrintWriter (new BufferedWriter
                                         (new FileWriter ("scores.out")));

            System.out.print (INPUT_PROMPT);
            /*sum =*/ addScores (sc, printWriter);                        
        } // try 
        catch (IOException e)
        {
              System.out.println (e);   
        } // catch IOException
        finally
        {             
            printWriter.close();            
        } // finally
    } // method run
    
    
    public int addScores (Scanner sc, PrintWriter printWriter)
    {
        final String HEADING = "Here are the test scores:";  
        
        final String RESULT = "\n\nThe sum of the scores is ";

        int score,
            sum = 0;
        
        printWriter.println (HEADING);              
        while (true) 
        {            
            score = sc.nextInt();
            if (score == SENTINEL)
                break;
            printWriter.println (score);
            sum += score;      
        } // while
        printWriter.println (RESULT + sum);
        return sum;
    } // method addScores
        
} // class Scores2
