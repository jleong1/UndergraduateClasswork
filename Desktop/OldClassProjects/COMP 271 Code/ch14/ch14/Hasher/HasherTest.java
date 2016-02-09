import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;
import java.util.*;
import java.io.*;

public class HasherTest 
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (HasherTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main  
    
    public static final int MAX_SOURCE_SIZE = 10000;
    
    protected Hasher hasher; 
    
    protected HashMap<String, String> symbolTable;

    
    @Before
    public void runBeforeEachTest() 
    {   
        hasher = new Hasher();                
        symbolTable = new HashMap<String, String> (MAX_SOURCE_SIZE);
    } // method runBeforeEachTest

          
    @Test
    public void testReadReservedWords() throws FileNotFoundException
    {                          
        Scanner fileScanner = new Scanner (new File ("reserved.dat"));
        hasher.readReservedWords (fileScanner, symbolTable);       
        assertEquals (hasher.RESERVED_WORD, symbolTable.get ("public"));
        assertEquals (hasher.RESERVED_WORD, symbolTable.get ("class"));
        assertEquals (hasher.RESERVED_WORD, symbolTable.get ("int"));
    } // method testReadReservedWords()
    
    
    @Test
    public void testIgnoreStringLiterals() throws FileNotFoundException
    { 
        Scanner fileScanner = new Scanner (new File ("source.in1"));
        
        hasher.readSourceCode (fileScanner, symbolTable);
        assertEquals (false, symbolTable.containsKey ("This is a String literal."));
        assertEquals (false, symbolTable.containsKey ("Heading"));
        assertEquals (false, symbolTable.containsKey ("Salaries by Department: "));
    } // method testIgnoreStringLiterals
 
} // class HasherTest
