
/**
 * Write a description of class SalariedEmployee here.
 * To initialize a salaried employee with default options for name, salary and bonus.
 * To initialize a salaried employee from a name, salary, and optional bonus 
 * To return the current salaried employee's salary
 * To return the current salaried employee's bonus
 * To return a String representation of the salaried employee, with the 
   name, gross pay (in MONEY format), and " FULL TIME SALARIED"
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SalariedEmployee extends FullTimeEmployee
{
   protected double bonus;
   protected double salary;
   
   public SalariedEmployee()
    {
         final String EMPTY_STRING = "";

         name = EMPTY_STRING;
         salary = 0.00;
         bonus = 0.00;
    } // default constructor 

   public  SalariedEmployee (String name, double salary, double bonus)
   {
       this.name = name;
       this.salary = salary;
       this.bonus = bonus;
    }
   public double getSalary()
    {       
        return salary;
    }
   public double getBonus()
   {
       return bonus;
    }
   public double getGrossPay()
   {
       return salary + bonus;
    }
   public String getName()
   {
       return name;
    }
   public String toString()
   {
       final String Employment = " FULL TIME SALARIED";
       return name + MONEY.format(bonus + salary) + Employment;
    }
}