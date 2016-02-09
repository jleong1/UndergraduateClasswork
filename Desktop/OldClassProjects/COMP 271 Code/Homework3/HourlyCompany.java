import java.util.*;

import java.io.*;

public class HourlyCompany extends Company
{
    public static void main (String[ ] args) throws FileNotFoundException 
    {
        new HourlyCompany().run();
    } // method main
   
 
    /**
     *  Returns the next hourly employee from the specified Scanner object. 
     *  
     *  @param sc the Scanner object used to scan in the next employee.
     *
     *  @return the next hourly employee scanned in from sc.
     *
     */  
    protected HourlyEmployee getNextEmployee (Scanner sc)
    {
        Scanner lineScanner = new Scanner (sc.nextLine());
        
        String name = lineScanner.next();       
                        
        int hoursWorked = lineScanner.nextInt();        
        
        double payRate = lineScanner.nextDouble();  

        return new HourlyEmployee (name, hoursWorked, payRate);
    } // method getNextEmployee     

} // class HourlyCompany 
