import java.util.*; // for the Scanner class

public class Scores1
{
    public final int SENTINEL = -1;    

    public static void main (String[ ] args) 
    {   
        new Scores1().run();
    } // method main
    
    public void run()
    {       
        final String INPUT_PROMPT = "\nOn each line, enter a test score (or " +
                                                           SENTINEL + " to quit): ";

        final String RESULT = "\n\nThe sum of the scores is ";

        Scanner sc = new Scanner (System.in);

        System.out.print (INPUT_PROMPT);

        int sum = addScores (sc);
        
        System.out.println (RESULT + sum);  
    } // method run
    
    /**
     *  Returns the sum of the scores scanned in.
     *
     *  @param sc – a (non-null reference to a) Scanner object from 
     *              which the scores are scanned in.
     * 
     *  @return the sum of the scores scanned in from sc.
     * 
     *  @throws InputMismatchException – if a value scanned in from sc is not an
     *                                   integer. 
     *
   */
    public int addScores (Scanner sc)
    {
        int score,
             sum = 0;

        while (true)
        {
            score = sc.nextInt();
            if (score == SENTINEL)
                break;
            sum += score;
        } // while
        return sum;  
    } // method addScores

} // class Scores1
