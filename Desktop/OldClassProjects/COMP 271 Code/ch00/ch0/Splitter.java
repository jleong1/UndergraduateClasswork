import java.util.*;

public class Splitter
{
  public static void main (String[] args)
  {
     new Splitter().run();
  } // method main

  public void run() 
  {
    // split ("Here today gone tomorrow");     
    // split ("Here today, gone tomorrow.");
    split ("You’re 21??  I’ll need to see some ID!");  
  } // method run

  public void split (String line)
  {
    // Scanner sc = new Scanner (line);
    // Scanner sc = new Scanner (line).useDelimiter ("[^a-zA-Z]+");
    Scanner sc = new Scanner (line).useDelimiter ("[^a-zA-Z’]+");

    while (sc.hasNext())
      System.out.println (sc.next().toLowerCase());
  } // method split
  
} // class Splitter
  

