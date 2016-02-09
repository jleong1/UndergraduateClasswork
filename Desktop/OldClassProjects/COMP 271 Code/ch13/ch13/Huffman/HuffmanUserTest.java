import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;

import java.util.*;
import java.io.*;

public class HuffmanUserTest 
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (HuffmanUserTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main  
    
    protected HuffmanUser huffmanUser;  
        
    
    @Before
    public void runBeforeEachTest() 
    {   
        huffmanUser = new HuffmanUser();                
    } // method runBeforeEachTest

    @Test
    public void testCreateEncoding0() throws FileNotFoundException
    {    
        Scanner fileScanner = new Scanner (new File ("huffman.in0"));                
        
        Huffman huffman = new Huffman();
        
        String expected = "\n 0000\na 001\nb 1\nc 0001\nd 01\n",
               actual;
        
        actual = huffmanUser.createEncoding (fileScanner, huffman);
        assertEquals (expected, actual);
    } // method testCreateEncoding0
         
    @Test
    public void testCreateEncoding1() throws FileNotFoundException
    {    
        Scanner fileScanner = new Scanner (new File ("huffman.in1"));                
        
        Huffman huffman = new Huffman();
        
        String expected = "\n 0110\n  1011\nd 100\ne 11\nm 001\nn 000\no 010\nr 0111\ny 1010\n",
               actual;
        
        actual = huffmanUser.createEncoding (fileScanner, huffman);
        assertEquals (expected, actual);
    } // method testCreateEncoding1  
    
    @Test
    public void testSaveEncodedMessage() throws IOException
    {            
        Huffman huffman = new Huffman();
        
        Scanner fileScanner = new Scanner (new File ("huffman.in0"));
        
        huffmanUser.createEncoding (fileScanner, huffman);
        
        PrintWriter printWriter = new PrintWriter (new FileWriter ("actual.ou0"));
                
        huffmanUser.saveEncodedMessage (printWriter, "huffman.in0", huffman); 
                     
        File actual = new File ("actual.ou0"),
             expected = new File ("expected.ou0");        
        Scanner scActual = new Scanner (actual),
                scExpected = new Scanner (expected);            
                   
        while (scActual.hasNextLine())            
           assertEquals (scExpected.nextLine(), scActual.nextLine());
        if (scExpected.hasNextLine())
            fail();
    } // method testSaveEncodedMessage  
         
} // class HuffmanUserTest
