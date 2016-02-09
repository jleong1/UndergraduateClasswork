import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;
import java.util.*;

public class NameChangeTest
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (NameChangeTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                                       "\nTests failed = " + result.getFailures());
    } // method main   

    public final static String EXCEPTION = "java.util.NoSuchElementException";

    public final static int EXCEPTION_LENGTH = EXCEPTION.length();
    
    protected NameChange change;
    
    protected String result;
    
    @Before    
    public void runBeforeEveryTest( )
    {
         change = new NameChange();
    } // method runBeforeEveryTest
 
    @Test
    public void rearrangeTest1() 
    { 
        result = change.rearrange ("John Quincy Adams");
        assertEquals ("Adams, John Q.", result); 
    } // method rearrangeTest1 
    
    @Test
    public void rearrangeTest2() 
    { 
        result = change.rearrange ("John Adams");
        assertEquals (EXCEPTION, result.substring (0, EXCEPTION_LENGTH)); 
    } // method rearrangeTest2
    
    @Test
    public void rearrangeTest3() 
    { 
        result = change.rearrange ("John");
        assertEquals (EXCEPTION, result.substring (0, EXCEPTION_LENGTH)); 
    } // method rearrangeTest3
    
    @Test
    public void rearrangeTest4() 
    { 
        result = change.rearrange ("");
        assertEquals (EXCEPTION, result.substring (0, EXCEPTION_LENGTH)); 
    } // rearrangeTest4       
     
} // class NameChangeTest
