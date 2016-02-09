import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;
import java.util.*;
import java.io.*;

public class EditorUserTest
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (EditorUserTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main
    
    protected EditorUser user;  
                       

    @Before
    public void runBeforeEachTest()
    {
        user = new EditorUser();
    } // method runBeforeEachTest
    
 
    @Test
    public void testEditText1() throws IOException
    {
            Scanner fileScanner = new Scanner (new File ("editor.in2"));
            PrintWriter fileWriter = new PrintWriter (new BufferedWriter 
                                         (new FileWriter ("editor.ou2")));
            user.editText (fileScanner, fileWriter);
            fileWriter.close();
            Scanner sc = new Scanner (new File ("editor.ou2"));           
            assertEquals ("$Insert", sc.nextLine());
            assertEquals ("a", sc.nextLine());
            assertEquals ("b", sc.nextLine());
            assertEquals ("$Done", sc.nextLine());            
            assertEquals ("", sc.nextLine() + sc.nextLine());
            assertEquals ("***********************", sc.nextLine());            
            assertEquals ("Here is the final text:", sc.nextLine());
            assertEquals ("   a", sc.nextLine());
            assertEquals ("   b", sc.nextLine());
            assertEquals (">  ", sc.nextLine());            
    } // method testEditText1

    @Test
    public void testEditText2() throws IOException
    {
            Scanner fileScanner = new Scanner (new File ("editor.in3"));
            PrintWriter fileWriter = new PrintWriter (new BufferedWriter 
                                                      (new FileWriter ("editor.ou3")));
            user.editText (fileScanner, fileWriter);
            fileWriter.close();
            Scanner sc = new Scanner (new File ("editor.ou3"));
            assertEquals ("$Insert", sc.nextLine());
            assertEquals ("a", sc.nextLine());
            assertEquals ("b", sc.nextLine());
            assertEquals ("$End", sc.nextLine());
            String s = sc.nextLine() + "\n";
            assertEquals ("java.lang.RuntimeException: " + 
                          Editor.BAD_COMMAND_MESSAGE, s);
            assertEquals ("", sc.nextLine());
            assertEquals ("$Done", sc.nextLine());
            assertEquals ("", sc.nextLine() + sc.nextLine());
            assertEquals ("***********************", sc.nextLine());       
            assertEquals ("Here is the final text:", sc.nextLine());           
            assertEquals ("   a", sc.nextLine());
            assertEquals ("   b", sc.nextLine());
            assertEquals (">  ", sc.nextLine());            
    } // method testEditText2
    
} // class EditorUserTest
