import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;

import java.util.*;

public class ComparableHeapSortTest
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (ComparableHeapSortTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main                                   

    @Test
    public void testSample() 
    {              
         Integer [ ] expected ={12,  16,  17,  32,  33,  40,  43,  44,  46,  46,  
                                50,  55,  59,  61,  75,  80,  80,  81,  87,  95};
         Integer [ ] actual = {59,  46,  32,  80,  46,  55,  50,  43,  44,  81,  
                                12,  95,  17,  80,  75,  33,  40,  61,  16,  87};           
         new PriorityQueue().heapSort (actual);
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
         
         new PriorityQueue().heapSort (actual);
         
         for (int i = 0; i < SIZE - 1; i++)
            if (actual [i] > actual [i + 1])
                 fail();
    } // method testRandom
    
    @Test (expected = NullPointerException.class)
    public void testNull()
    {
        new PriorityQueue().heapSort (null);
    } // method testNull
    
    @Test
    public void testMixed() 
    {                        
           String [] expected ={"43", "Atalanta", "Zeus", "be", "good", "to", "too", "true"};
           String[ ] actual = {"too", "good", "to", "be", "true", "Zeus", "43", "Atalanta"};

           new PriorityQueue().heapSort (actual);
           assertArrayEquals (expected, actual);          
    } // method testMixed
        
    public void testSimple() 
    {                       
           String[] expected ={"right", "rite", "wright", "write"} ;
           String[] actual = {"right", "write", "wright", "rite"};
           
           new PriorityQueue().heapSort (actual);
           assertArrayEquals (expected, actual);    
    } // method testSimple            
        
} // class ComparableHeapSortTest
