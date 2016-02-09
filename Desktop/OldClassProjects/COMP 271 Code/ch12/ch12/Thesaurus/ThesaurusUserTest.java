import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;
import java.util.*;
import java.io.*;

public class ThesaurusUserTest 
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (ThesaurusUserTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main  
    
    protected ThesaurusUser example;  
        
    protected String line;
        
    @Before
    public void runBeforeEachTest() 
    {   
        example = new ThesaurusUser();                
    } // method runBeforeEachTest


    @Test
    public void testProcessFilesNormal() throws IOException
    {        
        Scanner thesaurusFileScanner = new Scanner (new File ("thesaurus.in1")),
                requestFileScanner = new Scanner (new File ("requests.in1"));
                                                  
        PrintWriter synonymPrintWriter = new PrintWriter (new BufferedWriter 
                                        (new FileWriter ("synonyms.ou1")));
             
        Thesaurus thesaurus = new Thesaurus();
        while (thesaurusFileScanner.hasNext())
            thesaurus.add (thesaurusFileScanner.nextLine());
        example.findSynonyms (thesaurus, requestFileScanner, synonymPrintWriter);
        synonymPrintWriter.close();                                         
        Scanner sc = new Scanner (new File ("synonyms.ou1"));
                                         
        line = sc.nextLine();           
        assertEquals ("Here are the synonyms of confined: [close, cramped]", line);
        line = sc.nextLine();           
        assertEquals ("Here are the synonyms of near: [close]", line);
        line = sc.nextLine();           
        assertEquals ("x does not appear in the thesaurus.", line);
        line = sc.nextLine();           
        assertEquals ("Here are the synonyms of singular: [one, unique]", line);        
    } // method testProcessFilesNormal
 
    
    @Test // no exceptions thrown
    public void testProcessInputFileEmpty() 
    {              
        example.findSynonyms (null, new Scanner(""), null);                             
    } // method testProcessInputEmpty
         
} // class ThesaurusUserTest
