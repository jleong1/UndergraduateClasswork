import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;

import java.util.*;

public class HuffmanTest 
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (HuffmanTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main  
    
    protected Huffman huffman;  
        
    
    @Before
    public void runBeforeEachTest() 
    {   
        huffman = new Huffman();                
    } // method runBeforeEachTest

          
    @Test
    public void testUpdateFrequencies()
    {    
        Entry[] leafEntries = huffman.updateFrequencies ("more money needed");        
        assertEquals (2, leafEntries ['d'].getFreq());
        assertEquals (5, leafEntries ['e'].getFreq());
        assertEquals (2, leafEntries ['m'].getFreq());
        assertEquals (2, leafEntries ['n'].getFreq());
        assertEquals (2, leafEntries ['o'].getFreq());
        assertEquals (1, leafEntries ['r'].getFreq());
        assertEquals (1, leafEntries ['y'].getFreq());
    } // method testUpdateFrequencies
    
    
    @Test
    public void createPQ()
    {                      
        huffman.updateFrequencies ("aaabbbbbccdddd"); 
        PriorityQueue<Entry> pq = huffman.createPQ();
        assertEquals (1, pq.remove().getFreq()); 
        assertEquals (2, pq.remove().getFreq());
        assertEquals (3, pq.remove().getFreq());
        assertEquals (4, pq.remove().getFreq());
        assertEquals (5, pq.remove().getFreq());
    } // method testCreatePQ
    
    
    @Test
    public void testCreateHuffmanTree()
    {      
        huffman.updateFrequencies ("aabbbbbbbbcdddd"); 
        huffman.createPQ();
        Entry entry = huffman.createHuffmanTree();
        assertEquals (16, entry.getFreq()); // includes 'r'
    } // method testCreateHuffmanTree
      
    
     @Test
     public void testCalculateHuffmanCodes()
     {      
        huffman.updateFrequencies ("aaaabbbbbbbbbbbbbbbbccdddddddd"); 
        huffman.createPQ();
        huffman.createHuffmanTree();       
        Entry[] leafEntries = huffman.calculateHuffmanCodes();
        assertEquals ("0000", leafEntries ['\n'].getCode());            
        assertEquals ("001", leafEntries ['a'].getCode());            
        assertEquals ("1", leafEntries ['b'].getCode()); 
        assertEquals ("0001", leafEntries ['c'].getCode()); 
        assertEquals ("01", leafEntries ['d'].getCode()); 
     } // method testCalculateHuffmanCodes
     
     @Test
     public void testGetCodes() 
     {      
        huffman.updateFrequencies ("aaaabbbbbbbbbbbbbbbbccdddddddd"); 
        huffman.createPQ();
        huffman.createHuffmanTree(); 
        huffman.calculateHuffmanCodes();
        assertEquals ("\n 0000\na 001\nb 1\nc 0001\nd 01\n", huffman.getCodes());
     } // method testGetCodes
     
     
     @Test
     public void testGetEncodedLine()
     {      
        huffman.updateFrequencies ("aaaabbbbbbbbbbbbbbbbccdddddddd"); 
        huffman.createPQ();
        huffman.createHuffmanTree(); 
        huffman.calculateHuffmanCodes();
        assertEquals 
            ("00100100100111111111111111110001000101010101010101010000", 
             huffman.getEncodedLine ("aaaabbbbbbbbbbbbbbbbccdddddddd"));                    
     } // method testCalculateHuffmanCodes
     
} // class HuffmanTest
