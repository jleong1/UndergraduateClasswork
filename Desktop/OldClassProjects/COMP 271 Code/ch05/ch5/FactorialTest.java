import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;
import java.util.*;

public class FactorialTest
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (FactorialTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                                       "\nTests failed = " + result.getFailures());
    } // method main   

    @Test 
    public void factorialTest1() 
    {                                               
        assertEquals (24,  factorial (4));       
    } // method factorialTest1
    
    @Test
    public void factorialTest2()
    {                                                 
        assertEquals (1, factorial (0));        
    } // method factorialTest2
    
    @Test
    public void factorialTest3()
    {                                          
        assertEquals (1, factorial (1));       
    } // method factorialTest3
    
    @Test
    public void factorialTest4()
    {                                      
        assertEquals (2432902008176640000L, factorial (20));       
    } // method factorialTest4
    
    @Test (expected = IllegalArgumentException.class)
    public void factorialTest5()
    {               
        factorial (21);            
    } // method factorialTest5
    
    @Test (expected = IllegalArgumentException.class)
    public void factorialTest6 ()
    {        
        factorial (-1);            
    } // method factorialTest6


    public static long factorial (int n) 
    {
      // throw new UnsupportedOperationException();
      
       final int MAX_INT = 20;      // because 21! > Long.MAX_VALUE
     
       final String ERROR_MESSAGE = "The value of n must be >= 0 and <= " + 
                                  Integer.toString (MAX_INT);
     
       if (n < 0 || n > MAX_INT)
            throw new IllegalArgumentException (ERROR_MESSAGE);
       return fact (n);
      
       
//       long product = n;
//
//       if (n == 0)
//               return 1;
//       for (int i = n-1; i > 1; i--)
//              product = product * i; 
//       return product;
    } // method factorial

    /**
     * Calculates n!.  
     *
     *  @param n the integer whose factorial is calculated.
     *
     *  @return n!.             
     *
     */
    protected static long fact (int n)
    { 
      if (n <= 1)
         return 1; 
      return n * fact (n - 1);   
    } // method fact
 
} // class FactorialTest
