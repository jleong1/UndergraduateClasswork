import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;

import java.util.*;

public class NumberWordsTest
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (NumberWordsTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main   

    public final static String EXCEPTION = "java.util.InputMismatchException";   
    
    protected NumberWords numberWords;        
    
    @Before    
    public void runBeforeEveryTest( )
    {
         numberWords = new NumberWords();
    } // method runBeforeEveryTest
 
    @Test
    public void test805() 
    {         
        assertEquals ("805 is eight zero five ", numberWords.getNumberWords (new Scanner ("805"))); 
    } // method test805 
    
    @Test
    public void test0() 
    {         
        assertEquals ("0 is zero ", numberWords.getNumberWords (new Scanner ("0"))); 
    } // method test0 
    
    @Test
    public void testMinus17() 
    {         
        assertEquals ("-17 is minus one seven ", numberWords.getNumberWords (new Scanner ("-17"))); 
    } // method testMinus17 
    
    @Test
    public void test22z2() 
    {         
        assertEquals (EXCEPTION + ": 22z2 is not an int.", numberWords.getNumberWords (new Scanner ("22z2"))); 
    } // method testtest22z2 
    
     @Test
    public void testx() 
    {         
        assertEquals (EXCEPTION + ": x is not an int.", numberWords.getNumberWords (new Scanner ("x"))); 
    } // method testtestx 
        
} // class NumberWordsTest
