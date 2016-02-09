import java.util.*;   // for the Scanner class

public class Mutable
{
  public static void main (String[ ] args) 
  {
       new Mutable().run();
  } // method main

  public void run()
  {
       Scanner sc = new Scanner ("yes no maybe");
      
       System.out.println (sc.next());
       advance (sc);
       System.out.println (sc.next());
  } // method run 
  
  public void advance (Scanner scanner)
  {
        scanner.next();
  } // method advance

} // class Mutable
