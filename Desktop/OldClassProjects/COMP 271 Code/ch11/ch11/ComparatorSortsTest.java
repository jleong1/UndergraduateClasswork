import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;

import java.util.*;

public class ComparatorSortsTest
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (ComparatorSortsTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main                                   

    @Test
    public void testSample() 
    {              
         Integer [ ] expected ={95, 87, 81, 80, 80, 75, 61, 59, 55, 50, 46, 46,
                                44, 43, 40, 33, 32, 17, 16, 12};
         
         Integer [ ] actual = {59,  46,  32,  80,  46,  55,  50,  43,  44,  81,  
                               12,  95,  17,  80,  75,  33,  40,  61,  16,  87};           
         ComparatorSorts.insertionSort (actual, new Decreasing()); 
         // ComparatorSorts.selectionSort (actual, new Decreasing()); 
         // ComparatorSorts.bubbleSort (actual, new Decreasing()); 
         assertArrayEquals (expected, actual);                  
    } // method testSample
    
    @Test
    public void testRandom() 
    {     
         final int SIZE = 1000,
                   SEED = 100;
         
         Integer [ ] actual = new Integer [SIZE];
         
         Random r = new Random (SEED);
         
         for (int i = 0; i < SIZE; i++)
             actual [i] = r.nextInt();
         
         ComparatorSorts.insertionSort (actual, new Decreasing()); 
         // ComparatorSorts.selectionSort (actual, new Decreasing()); 
         // ComparatorSorts.bubbleSort (actual, new Decreasing()) 
         
         for (int i = 0; i < SIZE - 1; i++)
            if (actual [i] < actual [i + 1])
                 fail();
    } // method testRandom
    
    @Test (expected = NullPointerException.class)
    public void testNull1()
    {
        ComparatorSorts.insertionSort (null, new Decreasing());
        // Sorts.selectionSort (actual); 
        // Sorts.bubbleSort (actual); 
    } // method testNull1
    
    @Test (expected = NullPointerException.class)
    public void testNull2()
    {
        Integer [ ] actual = {59,  46,  32,  80,  46,  55,  50,  43,  44,  81,  
                               12,  95,  17,  80,  75,  33,  40,  61,  16,  87};  
        ComparatorSorts.insertionSort (actual, null);
        // Sorts.selectionSort (actual); 
        // Sorts.bubbleSort (actual); 
    } // method testNull2
    
    @Test
    public void testMixed() 
    {                        
           String [] expected ={"43", "be", "to", "too", "Zeus", "good", "true", "Atalanta"};
           String[ ] actual = {"too", "good", "to", "be", "true", "Zeus", "43", "Atalanta"};

           ComparatorSorts.insertionSort (actual, new ByLength());
           // ComparatorSorts.selectionSort (actual, new ByLength()); 
           // ComparatorSorts.bubbleSort (actual new ByLength()); 
           assertArrayEquals (expected, actual);          
    } // method testMixed
    
    
    public void testSimple() 
    {                       
           String[] expected ={"rite", "right", "write", "wright"} ;
           String[] actual = {"write", "right", "wright", "rite"};
           
           ComparatorSorts.insertionSort (actual, new ByLength());
           // ComparatorSorts.selectionSort (actual, new ByLength()); 
           // ComparatorSorts.bubbleSort (actual, new ByLength()); 
           assertArrayEquals (expected, actual);    
    } // method testSimple            
        
} // class ComparatorSortsTest
