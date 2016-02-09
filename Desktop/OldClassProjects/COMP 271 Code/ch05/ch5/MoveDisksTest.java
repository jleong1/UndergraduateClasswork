import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;
import java.util.*;

public class MoveDisksTest
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (MoveDisksTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                                       "\nTests failed = " + result.getFailures());
    } // method main   

    @Test 
    public void moveDisksTest1() 
    {                                               
        assertEquals ("Move disk 1 from A to B\nMove disk 2 from A to C\n" +
                      "Move disk 1 from B to C\nMove disk 3 from A to B\n" +
                      "Move disk 1 from C to A\nMove disk 2 from C to B\n" +
                      "Move disk 1 from A to B\n", moveDisks (3, 'A', 'B', 'C'));       
    } // method moveDisksTest1
    
    @Test
    public void moveDisksTest2()
    {                                                 
        assertEquals ("Move disk 1 from A to C\nMove disk 2 from A to B\n" +
                      "Move disk 1 from C to B\nMove disk 3 from A to C\n" +
                      "Move disk 1 from B to A\nMove disk 2 from B to C\n" +
                      "Move disk 1 from A to C\nMove disk 4 from A to B\n" +
                      "Move disk 1 from C to B\nMove disk 2 from C to A\n" +
                      "Move disk 1 from B to A\nMove disk 3 from C to B\n" +
                      "Move disk 1 from A to C\nMove disk 2 from A to B\n" +
                      "Move disk 1 from C to B\n", moveDisks (4, 'A', 'B', 'C'));        
    } // method moveDisksTest2
            
    @Test (expected = IllegalArgumentException.class)
    public void moveDisksTest3()
    {               
        moveDisks (0, 'A', 'B', 'C');           
    } // method moveDisksTest5
       
    public static String moveDisks (int n, char orig, char dest, char temp) 
    {
       // throw new UnsupportedOperationException();
      if (n <= 0)
        throw new IllegalArgumentException( );        
      return move (n, orig, dest, temp);
    } // method moveDisks 
    
    public static String move (int n, char orig, char dest, char temp) 
    {
       final String DIRECT_MOVE = 
         "Move disk " + n + " from " + orig + " to " + dest + "\n";
        
      if (n == 1)
         return DIRECT_MOVE;
      String result = move (n - 1, orig, temp, dest);
      result += DIRECT_MOVE;
      result += move (n - 1, temp, dest, orig) ;
      return result;
    } // method move 
   
} // class MoveDisksTest
