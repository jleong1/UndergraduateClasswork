import java.util.*;

public class TreeMapExample
{
     public static void main (String[ ] args) 
     {
          new TreeMapExample().run();
     } // method main
    
     public void run()
     {
          TreeMap<String,Double> students = new TreeMap<String,Double>();

          students.put ("Bogan, James", 3.85);
          students.put ("Zawada, Matt", 3.95);
          students.put ("Balan, Tavi", 4.00);
          students.put ("Nikolic, Lazar", 3.85);

          System.out.println (students);

          for (Map.Entry<String, Double> entry : students.entrySet())
              if (entry.getValue() > 3.9)
                  System.out.println (entry.getKey() + " " + entry.getValue());

          System.out.println (students.remove ("Brown, Robert"));
          System.out.println (students.remove ("Zawada, Matt"));
          System.out.println (students.containsKey ("Tavi Balan"));
          System.out.println (students.containsKey ("Balan, Tavi"));
          System.out.println (students.containsValue (3.85));
      } // method run

} // class TreeMapExample
