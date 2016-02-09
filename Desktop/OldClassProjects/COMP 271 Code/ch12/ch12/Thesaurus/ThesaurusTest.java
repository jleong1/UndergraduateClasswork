import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;
import java.util.*;
import java.io.*;

public class ThesaurusTest extends Thesaurus
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (ThesaurusTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main  
    
    protected Thesaurus thesaurus;  
        
    
    @Before
    public void runBeforeEachTest() 
    {   
        thesaurus = new Thesaurus();                
    } // method runBeforeEachTest

  
    @Test (expected = NullPointerException.class)
    public void testAddLineNull() 
    {                         
        thesaurus.add (null);          
    } // method testAddLineNull
    

    @Test
    public void testAdd1()
    {
         thesaurus.add ("therefore since because ergo");
         assertEquals ("{therefore=[since, because, ergo]}", thesaurus.toString());                       
    } // method testAdd1


    @Test (expected = NullPointerException.class)
    public void testGetWordNull()
    {                
        thesaurus.add ("serene peaceful calm");                        
        thesaurus.getSynonyms (null);
    } // method testGetWordNull
   
    
    @Test
    public void testGetSynonyms()
    {                              
        thesaurus.add ("serene peaceful calm");
        assertEquals ("[peaceful, calm]", thesaurus.getSynonyms ("serene").toString());                                
    } // method testGetSynonyms
    
    
    @Test
    public void testToString()
    {                      
        thesaurus.add ("serene peaceful calm");
        thesaurus.add ("therefore since because ergo");
        assertEquals ("{serene=[peaceful, calm], therefore=[since, because, ergo]}", 
                      thesaurus.toString());                                 
    } // method testGetSynonyms
    
    
    @Test
    public void testGetNoSynonyms()
    {                               
        thesaurus.add ("serene peaceful calm");
        assertEquals (null, thesaurus.getSynonyms ("calm"));                                  
    } // method testGetNoSynonyms
      
} // class ThesaurusTest
