import java.util.*;

public class HashExample
{
    public static void main (String[ ] args)
    {
        new HashExample().run();
    } // method main
    
    public void run()
    {
        HashMap<String, Integer> ageMap = new HashMap<String, Integer>();
        ageMap.put ("dog", 15);
        ageMap.put ("cat", 20);
        ageMap.put ("human", 75);
        ageMap.put ("turtle", 100);
        System.out.println (ageMap);
        for (String s : ageMap.keySet())
            System.out.println (s);
      for (Integer i : ageMap.values())
          System.out.println (i);
    } // method run
    
} // class HashExample