import java.util.*;

import java.io.*;
/**
 * Write a description of class SalariedCompany here.
 *  to calculate the best-paid salaried employee.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SalariedCompany extends Company
{
  
    public static void main (String[ ] args) throws FileNotFoundException
    {
        new SalariedCompany().run();
    }
  
    public SalariedEmployee findBestPaid (Scanner sc)
    {
        SalariedEmployee full, 
                         bestPaid = new SalariedEmployee();                            
       
        while (sc.hasNext())
        {                               
             full = getNextEmployee (sc);           
             if (full.getSalary() + full.getBonus()> bestPaid.getSalary() + bestPaid.getBonus())
                bestPaid = full; 
        }   
        if (bestPaid.getGrossPay() == 0.00)    
          return null;
        return bestPaid;
    } 
    protected SalariedEmployee getNextEmployee (Scanner sc)
    {
        Scanner lineScanner = new Scanner (sc.nextLine());
        
        String name = lineScanner.next();
        
        double salary = lineScanner.nextDouble();
        
        double bonus = lineScanner.nextDouble ();

        return new SalariedEmployee (name, salary, bonus);
    }
}
