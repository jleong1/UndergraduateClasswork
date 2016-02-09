import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;

import java.util.*;

public class SortsTest
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (SortsTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main                                   
    
    @Test
    public void testSample() 
    {              
         int [ ] expected ={12,  16,  17,  32,  33,  40,  43,  44,  46,  46,  
                                50,  55,  59,  61,  75,  80,  80,  81,  87,  95};
         int [ ] actual = {59,  46,  32,  80,  46,  55,  50,  43,  44,  81,  
                                12,  95,  17,  80,  75,  33,  40,  61,  16,  87};           
         Sorts.insertionSort (actual); 
         //Sorts.selectionSort (actual); 
         // Sorts.bubbleSort (actual); 
         assertArrayEquals (expected, actual);                  
    } // method testSample
    
    @Test
    public void testRandom() 
    {     
         final int SIZE = 1000,
                   SEED = 100;
         
         int [ ] actual   = new int [SIZE];
         
         Random r = new Random (SEED);
         
         for (int i = 0; i < SIZE; i++)
             actual [i] = r.nextInt();
         
         Sorts.insertionSort (actual); 
         // Sorts.selectionSort (actual); 
         // Sorts.bubbleSort (actual); 
         
         for (int i = 0; i < SIZE - 1; i++)
            if (actual [i] > actual [i + 1])
                 fail();
    } // method testRandom

    @Test (expected = NullPointerException.class)
    public void testNull()
    {
       Sorts.insertionSort (null);
       // Sorts.selectionSort (actual); 
       // Sorts.bubbleSort (actual);
    } // method testNull
       
    @Test 
    public void test1() 
    {            
        int [ ] expected = {43, 99},
                  actual = {99, 43};
        Sorts.insertionSort (actual);
        // Sorts.selectionSort (actual); 
        // Sorts.bubbleSort (actual);
        assertArrayEquals (expected, actual);        
    } // test1            
    
} // class SortsTest
