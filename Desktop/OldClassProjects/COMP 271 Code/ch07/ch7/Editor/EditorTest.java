import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;
import java.util.*;

public class EditorTest extends Editor
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (EditorTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main
    
    protected Editor editor;  
                       
    @Before
    public void runBeforeEachTest()
    {
        editor = new Editor();
    } // method runBeforeEachTest
    
 
    @Test
    public void testInterpret()
    {
        assertEquals (null, editor.interpret ("$Insert"));        
    } // method testInterpret
    

    @Test (expected = RuntimeException.class)    
    public void testInterpretEmpty()
    {
        try
        {                    
            editor.interpret ("");            
        } // try
        catch (RuntimeException e)
        {
            assertEquals ("java.lang.RuntimeException: " + Editor.BAD_LINE_MESSAGE, e.toString());
            throw new RuntimeException();
        } // catch RuntimeException 
    } // method testInterpretEmpty

        
    @Test (expected = RuntimeException.class)    
    public void testInterpretBadCommand()
    {        
        try
        {                    
            editor.interpret ("$garbage");            
        } // try
        catch (RuntimeException e)
        {
            assertEquals ("java.lang.RuntimeException: " + Editor.BAD_COMMAND_MESSAGE, e.toString());
            throw new RuntimeException();
        } // catch RuntimeException 
    } // method testInterpretBadCommand
    
    
    @Test (expected = RuntimeException.class)    
    public void testInterpretBadLine()
    {
        try
        {                    
            editor.interpret ("$Delete 7 x");            
        } // try
        catch (RuntimeException e)
        {
            assertEquals ("java.lang.RuntimeException: " + 
                          Editor.TWO_INTEGERS_NEEDED, e.toString());
            throw new RuntimeException();
        } // catch RuntimeException 
    } // method testInterpretBadLine
    

    @Test (expected = RuntimeException.class)    
    public void testInterpretBadDelete()
    {
        try
        {                    
            editor.interpret ("$Delete 7 x");            
        } // try
        catch (RuntimeException e)
        {
            assertEquals ("java.lang.RuntimeException: " + Editor.TWO_INTEGERS_NEEDED, e.toString());
            throw new RuntimeException();
        } // catch RuntimeException 
    } // method testInterpretBadDelete

    
    @Test
    public void testInterpretNotInserting()
    {
        assertEquals (null, editor.interpret ("$Line 0"));                   
    } // method testInterpretNotInserting


    @Test    
    public void testInsert() 
    {                      
        editor.interpret ("$Insert");
        editor.insert ("a");
        editor.insert ("b");
        String actual = editor.interpret ("$Done"),
               expected = "   a\n   b\n>  \n";       
        assertEquals (expected, actual);                      
    } // method testInsert
    

    @Test (expected = RuntimeException.class)    
    public void testInsertTooLong() 
    {                      
        editor.interpret ("$Insert");
        editor.insert ("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                       "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                       "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                       "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    } // method testInsert
 

    @Test   
    public void testSetLineNumber()
    {
        editor.interpret ("$Insert");
        editor.insert ("c");
        editor.insert ("d");
        editor.setCurrentLineNumber (1);
        editor.insert ("x");
        String actual = editor.interpret ("$Done"),
               expected = "   c\n   x\n>  d\n";
        assertEquals (expected, actual);   
    } // method testSetLineNumber

    
    @Test (expected = RuntimeException.class)    
    public void testSetLineNumberHigh()
    {
        try
        {
            editor.interpret ("$Insert");
            editor.insert ("c");
            editor.insert ("d");
            editor.setCurrentLineNumber (3);
        } // try        
        catch (RuntimeException e)
        {
            assertEquals ("java.lang.RuntimeException: " + Editor.M_TOO_LARGE, e.toString());
            throw new RuntimeException();
        } // catch RuntimeException 
    } // method testSetLineNumberHigh
    
    @Test
    public void testDelete() 
    {                      
       editor.interpret ("$Insert");
       editor.insert ("a");
       editor.insert ("b");
       editor.insert ("c");
       editor.insert ("d");
       editor.insert ("e");
       editor.insert ("f");
       editor.delete (1, 3);
       String actual = editor.interpret ("$Done"),
              expected = "   a\n>  e\n   f\n";
       assertEquals (expected, actual);    
    } // method testDelete

   
    @Test (expected = RuntimeException.class)    
    public void testDeleteFirstGreater()
    {
       try
       {
           editor.interpret ("$Insert");
           editor.insert ("c");
           editor.insert ("d");
           editor.interpret ("$Delete 1 0");
       } // try        
       catch (RuntimeException e)
       {
           assertEquals ("java.lang.RuntimeException: " + Editor.FIRST_GREATER, e.toString());
           throw new RuntimeException();
       } // catch RuntimeException 
     } // method testDeleteFirstGreater
     

    @Test (expected = RuntimeException.class)    
    public void testDeleteFirstLess0()
    {
        try
        {
           editor.interpret ("$Insert");
           editor.insert ("c");
           editor.insert ("d");
           editor.interpret ("$Delete -1 0");
        } // try        
        catch (RuntimeException e)
        {
            assertEquals ("java.lang.RuntimeException: " + Editor.FIRST_LESS_THAN_ZERO, e.toString());
            throw new RuntimeException();
        } // catch RuntimeException 
    } // method testDeleteFirstLess0
     

    @Test (expected = RuntimeException.class)    
    public void testDeleteSecondHigh()
    {
        try
        {
            editor.interpret ("$Insert");
            editor.insert ("c");
            editor.insert ("d");
            editor.interpret ("$Delete 1 2");
        } // try        
        catch (RuntimeException e)
        {
            assertEquals ("java.lang.RuntimeException: " + Editor.SECOND_TOO_LARGE, e.toString());
            throw new RuntimeException();
        } // catch RuntimeException 
     } // method testDeleteSecondHigh


    @Test      
    public void testDoneEndCaret()
    {
        editor.interpret ("$Insert");
        editor.insert ("c");
        editor.insert ("d");
        String actual = editor.interpret ("$Done"),
               expected = "   c\n   d\n>  \n";
        assertEquals (expected, actual);
    } // method testDoneEndCaret
     
    
    @Test
    public void testDoneStartCaret()
    {
        editor.interpret ("$Insert");
        editor.insert ("c");
        editor.insert ("d");
        editor.setCurrentLineNumber (0);
        String actual = editor.interpret ("$Done"),
               expected = ">  c\n   d\n";
        assertEquals (expected, actual);
    } // method testDoneStartCaret
     
} // class EditorTest
