import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;
import java.util.*;

public class HourlyEmployeeTest
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (HourlyEmployeeTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                                       "\nTests failed = " + result.getFailures());
    } // method main   
 
    public static final double DELTA = 0.0000001;
    
    protected HourlyEmployee hourly;    
    
    @Test
    public void test1() 
    { 
        hourly = new HourlyEmployee ("andrew", 39, 10.00);
        assertEquals (390.00, hourly.getRegularPay(), DELTA);
        assertEquals (0.00, hourly.getOvertimePay(), DELTA);
        assertEquals (390.00, hourly.getGrossPay(), DELTA);
    } // method test1
    
    @Test
    public void test2() 
    { 
        hourly = new HourlyEmployee ("beth", 40, 20.00);        
        assertEquals (800.00, hourly.getRegularPay(), DELTA);
        assertEquals (0.00, hourly.getOvertimePay(), DELTA);
        assertEquals (800.00, hourly.getGrossPay(), DELTA);
    } // method test2
    
    @Test
    public void test3() 
    { 
        hourly = new HourlyEmployee ("terry", 41, 20.00);        
        assertEquals (800.00, hourly.getRegularPay(), DELTA);
        assertEquals (30.00, hourly.getOvertimePay(), DELTA);
        assertEquals (830.00, hourly.getGrossPay(), DELTA);
    } // method test3
    
    @Test
    public void test4() 
    { 
        hourly = new HourlyEmployee ("karen", 50, 10);        
        assertEquals (400.00, hourly.getRegularPay(), DELTA);
        assertEquals (150.00, hourly.getOvertimePay(), DELTA);
        assertEquals (550.00, hourly.getGrossPay(), DELTA);
    } // method test4
    
} // class HourlyEmployeeTest
