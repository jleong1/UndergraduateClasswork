import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;
import java.util.*;
import java.io.*;  // for IOException, see Section 2.3

public class CompanyTest extends Company
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (CompanyTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                                       "\nTests failed = " + result.getFailures());
    } // method main    

    protected Company company;
 
    protected FullTimeEmployee best; 
    
    protected Scanner sc;
    
    protected String expected;                     
    
   @Before
    public void runBeforeEveryTest()
    {
        company = new Company();
    } // method runBeforeEveryTest

    @Test
    public void getNextEmployeeTest1()
    {
        sc = new Scanner ("Lucas 350.00");
        expected = "Lucas $350.00 FULL TIME";
        assertEquals (expected, company.getNextEmployee (sc).toString());
    } // method getNextEmployeeTest1

    @Test
    public void findBestPaidTest1() throws IOException
    {
        sc = new Scanner (new File ("company.in1"));
        best = company.findBestPaid (sc);
        expected = "b $150.00 FULL TIME";
        assertEquals (expected, best.toString());
    } // method findBestPaidTest1  

   @Test
    public void findBestPaidTest2() throws IOException
    {
        sc = new Scanner (new File ("company.in2"));
        best = company.findBestPaid (sc);
        assertEquals (null, best);
    } // method findBestPaidTest2
} // class CompanyTest
