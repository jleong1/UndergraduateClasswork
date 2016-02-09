import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;
import java.util.*;

public class DecimalToBinaryTest
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (DecimalToBinaryTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                                       "\nTests failed = " + result.getFailures());
    } // method main   

    @Test 
    public void getBinaryTest1() 
    {                                               
        assertEquals ("100000000",  getBinary (256));       
    } // method binaryTest1
    
    @Test
    public void getBinaryTest2()
    {                                                 
        assertEquals ("0", getBinary (0));        
    } // method getBinaryTest2
    
    @Test
    public void getBinaryTest3()
    {                                          
        assertEquals ("1", getBinary (1));       
    } // method getBinaryTest3
    
    @Test
    public void getBinaryTest4()
    {   
        // Integer.MAX_VALUE = 0X7fffffff = 31 ones in binary
        assertEquals ("1111111111111111111111111111111", getBinary (Integer.MAX_VALUE));       
    } // method getBinaryTest4
    
    @Test (expected = IllegalArgumentException.class)
    public void getBinaryTest5()
    {               
        getBinary (-1);            
    } // method getBinaryTest5
       
    public static String getBinary (int n) 
    {
      // throw new UnsupportedOperationException();
      if (n < 0)
         throw new IllegalArgumentException();        
      return getBin (n);
    } // method getBinary
 
    public static String getBin (int n) 
    {  
        if (n <= 1)
            return Integer.toString (n);
        return getBin (n / 2) + Integer.toString (n % 2);
    } // method getBin
 
} // class DecimalToBinaryTest
