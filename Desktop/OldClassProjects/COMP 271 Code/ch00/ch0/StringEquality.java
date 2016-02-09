public class StringEquality
{
    public static void main (String[] args)
    {      
        String s4 = new String ("restful"),
               s5 = new String ("restful"), 
               s6 = new String ("peaceful"),
               s7 = s4,
               s8 = "restful",
               s9 = "restful";

               System.out.println (s4.equals (s5));   // the output is "“true"”
               System.out.println (s4.equals (s6));   // the output is "“false"”
               System.out.println (s4 == s5);         // the output is "“false"”
               System.out.println (s4 == s7);         // the output is "“true"”
               System.out.println (s4 == s8);         // the output is "“false"”
               System.out.println (s8 == s9);         // the output is "“true"”
    } // method main

} // class StringEquality
