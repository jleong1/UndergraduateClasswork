import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;
import java.util.*;

public class BinarySearchTest
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (BinarySearchTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                                       "\nTests failed = " + result.getFailures());
    } // method main 
    
    final String[ ] names = {"Ada", "Ben", "Carol", "Dave", "Ed", "Frank",
                   "Gerri", "Helen", "Iggy", "Joan"};

    @Test 
    public void binarySearchTest1() 
    {                                               
        assertEquals (4,  binarySearch (names, "Ed"));       
    } // method binarySearchTest1
    
    @Test
    public void binarySearchTest2()
    {                                                 
        assertEquals (-4, binarySearch (names, "Dan"));        
    } // method binarySearchTest2
    
    @Test
    public void binarySearchTest3()
    {                                          
        assertEquals (0, binarySearch (names, "Ada"));       
    } // method binarySearchTest3
    
    @Test
    public void binarySearchTest4()
    {                                      
        assertEquals (9, binarySearch (names, "Joan"));       
    } // method factorialTest4
    
    @Test
    public void binarySearchTest5()
    {                                          
        assertEquals (-1, binarySearch (names, "Aaron"));       
    } // method binarySearchTest5
    
    @Test
    public void binarySearchTest6()
    {                                      
        assertEquals (-11, binarySearch (names, "Joseph"));       
    } // method factorialTest6
    
    @Test (expected = ClassCastException.class)
    public void binarySearchTest7()
    {                                      
        binarySearch (names, 7);       
    } // method factorialTest7
    
    public static int binarySearch(Object[ ] a, Object key) 
    {
       // throw new UnsupportedOperationException(); 
       return binarySearch (a, 0, a.length - 1, key);
    } // method binarySearch
         
    public static  int binarySearch(Object[ ] a, int first, int last, Object key) 
    {                
        if (first <= last) 
        {
            int mid = (first + last) >> 1;
            Comparable midVal = (Comparable)a [mid];
            int comp = midVal.compareTo (key);
            if (comp < 0)
                 return binarySearch (a, mid + 1, last, key);
            if (comp > 0)
                 return binarySearch (a, first, mid - 1, key);
            return mid;  // key found
        } // if first <= last
        return -first - 1; // key not found; belongs at a[first]
     } // method binarySearch

    
} // class BinarySearchTest
