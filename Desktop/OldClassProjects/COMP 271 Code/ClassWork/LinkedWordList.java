import java.io.*;
import java.util.*;
/**
 * Write a description of class LinkedWordList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LinkedWordList 
{
       public static void main (String[] args) {
        LinkedList <String> w  = new LinkedList<String>();
        Scanner reader=null;
        try { reader = new Scanner(new File("EnglishWordList.txt"));
           }
            catch ( FileNotFoundException ex)
            {System.out.println(ex+"file not found ");
            }
            while (reader.hasNext()){
        String str = reader.nextLine();
        System.out.println(str);
        if(w.isEmpty())
        {
            if (!w.contains(str)){
            w.add(str);
        }
        }
   }
}
}
