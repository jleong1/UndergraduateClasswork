import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;
import java.util.*;
import java.io.*;

public class MazeTest
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (MazeTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main
    
    protected Maze maze;         
   
    @Before
    public void createMaze() throws FileNotFoundException
    {
        maze = new Maze (new Scanner (new File ("maze.txt")));       
    } // method createMaze
    
    @Test
    public void testConstructor1() throws FileNotFoundException
    {
       maze = new Maze (new Scanner (new File ("maze.in0")));
       
       byte[][] expected = {{1, 0}, {1, 0}, {1, 1}};
       
       assertArrayEquals (expected, maze.getGrid());
    } // testConstructor1
    
    @Test (expected = InputMismatchException.class)
    public void testConstructor2() throws FileNotFoundException
    {
       maze = new Maze (new Scanner (new File ("maze.in1")));              
    } // testConstructor2
    
    @Test (expected = NumberFormatException.class)
    public void testConstructor3() throws FileNotFoundException
    {
       maze = new Maze (new Scanner (new File ("maze.in2")));              
    } // testConstructor3
    
    @Test
    public void testNext1()
    {
        Position pos = new Position (0, 12);
        Iterator<Position> itr = maze.iterator (pos);
        Position next = itr.next();  // north to (-1, 12)
        assertEquals (-1, next.getRow());
    } // testNext1

    @Test
    public void testNext2()
    {
        Position pos = new Position (0, 12);
        Iterator<Position> itr = maze.iterator (pos);
        Position next = itr.next();  // north to (-1, 12)
        assertEquals (12, next.getColumn());
    } // testNext2
    
    @Test
    public void testNext3()
    {
        Position pos = new Position (0, 12);
        Iterator<Position> itr = maze.iterator (pos);
        Position next = itr.next();  
        next = itr.next();  // east to (0, 13)
        assertEquals (0, next.getRow());
    } // testNext3
    
    @Test
    public void testNext4()
    {
        Position pos = new Position (0, 12);
        Iterator<Position> itr = maze.iterator (pos);
        Position next = itr.next();
        next = itr.next();  // east to (0, 13)
        assertEquals (13, next.getColumn());
    } // testNext4
    
     @Test
    public void testNext5()
    {
        Position pos = new Position (0, 12);
        Iterator<Position> itr = maze.iterator (pos);
        Position next = itr.next();  
        next = itr.next();
        next = itr.next(); // south to (1, 12)
        assertEquals (1, next.getRow());
    } // testNext5

    @Test
    public void testNext6()
    {
        Position pos = new Position (0, 12);
        Iterator<Position> itr = maze.iterator (pos);
        Position next = itr.next();  
        next = itr.next();
        next = itr.next(); // south to (1, 12)
        assertEquals (12, next.getColumn());
    } // testNext6
    
    @Test
    public void testNext7()
    {
        Position pos = new Position (0, 12);
        Iterator<Position> itr = maze.iterator (pos);
        Position next = itr.next();  
        next = itr.next();  
        next = itr.next(); 
        next = itr.next(); // west to (0, 11);
        assertEquals (0, next.getRow());
    } // testNext7
    
    @Test
    public void testNext8()
    {
        Position pos = new Position (0, 12);
        Iterator<Position> itr = maze.iterator (pos);
        Position next = itr.next();
        next = itr.next();  
        next = itr.next();
        next = itr.next();  // west to (0, 11);
        assertEquals (11, next.getColumn());
    } // testNext8
    
    @Test
    public void isOKTest1()
    {
        Position pos = new Position (0, 0);
        assertEquals (true, maze.isOK (pos));
    } // isOKTest1

  @Test
    public void isOKTest2()
    {
        Position pos = new Position (6, 12);
        assertEquals (true, maze.isOK (pos));
    } // isOKTest2

  @Test
    public void isOKTest3()
    {
        Position pos = new Position (7, 0);
        assertEquals (false, maze.isOK (pos));        
    } // isOKTest3
   
    @Test
    public void isOKTest4()
    {
        Position pos = new Position (0, 13);   
        assertEquals (false, maze.isOK (pos));
    } // isOKTest4
    
    @Test
    public void isOKTest5()
    {
        Position pos = new Position (0, 0);
        Iterator<Position> itr = maze.iterator (pos);            
        pos = itr.next(); // north to (-1, 0)                 
        assertEquals (false, maze.isOK (pos)); 
    } // isOKTest5
    
     @Test
    public void isOKTest6()
    {
        Position pos = new Position (0, 0);
        Iterator<Position> itr = maze.iterator (pos);            
        pos = itr.next();
        pos = itr.next(); //true, maze.isOK (pos));
    } // isOKTest6

      @Test
    public void isOKTest7()
    {
        Position pos = new Position (0, 0);
        Iterator<Position> itr = maze.iterator (pos);            
        pos = itr.next();
        pos = itr.next(); 
        pos = itr.next();  // south to (1, 0)
        assertEquals (true, maze.isOK (pos));
    } // isOKTest7
      
    @Test
    public void isOKTest8()
    {
        Position pos = new Position (0, 0);
        Iterator<Position> itr = maze.iterator (pos);            
        pos = itr.next();
        pos = itr.next(); 
        pos = itr.next();  
        pos = itr.next();  // west to (0, -1)
        assertEquals (false, maze.isOK (pos));
    } // isOKTest8
    
    @Test
    public void markPossibleTest()
    {
       Position pos = new Position (5, 3);
       
       int expected = maze.PATH;
       
       maze.markAsPossible (pos);
       assertEquals (expected, maze.getGrid()[5][3]);
    } // method markPossibleTest                             
    
    @Test
    public void markDeadEndTest()
    {
       Position pos = new Position (5, 3);
       
       int expected = maze.DEAD_END;
       
       maze.markAsDeadEnd (pos);
       assertEquals (expected, maze.getGrid()[5][3]);
    } // method markDeadEndTest   
    
    @Test
    public void isGoalTest1()
    {
        Position pos = new Position (0, 0);       
        assertEquals (false, maze.isGoal (pos));
    } // isGoalTest1
     
     @Test
    public void isGoalTest2()
    {
        Position pos = new Position (6, 12);       
        assertEquals (true, maze.isGoal (pos));
    } // isGoalTest2
    
} // class MazeTest
