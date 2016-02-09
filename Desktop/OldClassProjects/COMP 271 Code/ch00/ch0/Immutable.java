public class Immutable
{  
  public static void main (String[ ] args) 
  {
    new Immutable().run();
  } // method main

  public void run()
  {
    String s = "yes";
    flip (s);
    System.out.println (s);
  } // method run

  public void flip (String t)
  {
      t = new String ("no");
  } // method flip
  
} // class Immutable
