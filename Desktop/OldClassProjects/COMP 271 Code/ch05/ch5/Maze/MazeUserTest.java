import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;
import java.util.*;
import java.io.*;

public class MazeUserTest
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (MazeUserTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main
    
    protected MazeUser mazeUser = new MazeUser();         
   
    protected Maze maze;  
    
    protected Scanner fileScanner;                         
    
    @Test 
    public void testMazeUser1() throws FileNotFoundException
    {    
        mazeUser = new MazeUser();
        fileScanner = new Scanner (new File ("maze.in4"));
        maze = new Maze (fileScanner);        
        assertEquals (true, mazeUser.searchMaze (maze));
    } // testMazeUser1
        
    @Test 
    public void testMazeUser2() throws FileNotFoundException
    {    
        mazeUser = new MazeUser();
        fileScanner = new Scanner (new File ("maze.in5"));
        maze = new Maze (fileScanner);        
        assertEquals (false, mazeUser.searchMaze (maze));
    } // testMazeUser2
   
     @Test 
    public void testMazeUser3() throws FileNotFoundException
    {    
        mazeUser = new MazeUser();
        fileScanner = new Scanner (new File ("maze.in6"));
        maze = new Maze (fileScanner);        
        assertEquals (true, mazeUser.searchMaze (maze));
    } // testMazeUser3
                   
} // class MazeUserTest
