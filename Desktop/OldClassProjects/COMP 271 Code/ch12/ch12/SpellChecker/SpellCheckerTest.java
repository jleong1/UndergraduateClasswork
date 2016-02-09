import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;
import java.util.*;

public class SpellCheckerTest extends SpellChecker
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (SpellCheckerTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main  
    
    protected SpellChecker spellChecker;  
        
    
    @Before
    public void runBeforeEachTest() 
    {   
        spellChecker = new SpellChecker();                
    } // method runBeforeEachTest
     
    
    @Test (expected = NullPointerException.class)
    public void testAddNullToDocumentSet()
    {                
        spellChecker.addToDocument (null);                                
    } // method testNullToDocumentSet
   
    
    @Test
    public void testAddToDocument1()
    {
        String actual = spellChecker.addToDocument ("A man, a plan, a canal. Panama!");
        assertEquals ("[a, canal, man, panama, plan]", actual);
    } // method testAddToDocumentSet1

  
    @Test
    public void testNoMisspellings()
    {                              
        spellChecker.addToDictionary ("serene");
        spellChecker.addToDictionary ("calm");
        spellChecker.addToDocument ("serene, calm");
        assertEquals ("[]", spellChecker.compare().toString());                                
    } // method testNoMisspellings
    
    
    @Test
    public void testOneMisspelling()
    {                      
        spellChecker.addToDictionary ("serene");
        spellChecker.addToDictionary ("calm");
        spellChecker.addToDocument ("serene, peaceful, 123, calm");
        assertEquals ("[peaceful]", spellChecker.compare().toString());                                 
    } // method testOneMisspelling
    
    
    @Test
    public void testSeveralMisspellings1()
    {      
        spellChecker.addToDictionary ("separate");        
        spellChecker.addToDictionary ("algorithms");
        spellChecker.addToDictionary ("equals");
        spellChecker.addToDictionary ("asterisk");
        spellChecker.addToDictionary ("wore");
        spellChecker.addToDictionary ("coat");
        spellChecker.addToDictionary ("she");
        spellChecker.addToDictionary ("equals");
        spellChecker.addToDictionary ("plus");
        spellChecker.addToDictionary ("he");
        spellChecker.addToDictionary ("pied");
        spellChecker.addToDictionary ("a");
        spellChecker.addToDictionary ("pile");        
        spellChecker.addToDictionary ("programs");                
        spellChecker.addToDictionary ("structures");        
        spellChecker.addToDocument ("Alogrithms plus Data Structures equal Programs.");
        String expected = "[alogrithms, data, equal]",
               actual = spellChecker.compare().toString();
        assertEquals (expected, actual);            
    } // method testSeveralMisspellings1
      
    
     @Test
    public void testSeveralMisspellings2()
    {      
        spellChecker.addToDictionary ("separate");        
        spellChecker.addToDictionary ("algorithms");
        spellChecker.addToDictionary ("equals");
        spellChecker.addToDictionary ("asterisk");
        spellChecker.addToDictionary ("wore");
        spellChecker.addToDictionary ("coat");
        spellChecker.addToDictionary ("she");
        spellChecker.addToDictionary ("equals");
        spellChecker.addToDictionary ("plus");
        spellChecker.addToDictionary ("he");
        spellChecker.addToDictionary ("pied");
        spellChecker.addToDictionary ("a");
        spellChecker.addToDictionary ("pile");        
        spellChecker.addToDictionary ("programs");                
        spellChecker.addToDictionary ("structures");        
        spellChecker.addToDocument ("She woar a pide coat.");
        String expected = "[pide, woar]",
               actual = spellChecker.compare().toString();
        assertEquals (expected, actual);            
    } // method testSeveralMisspellings2
     
} // class SpellCheckerTest
