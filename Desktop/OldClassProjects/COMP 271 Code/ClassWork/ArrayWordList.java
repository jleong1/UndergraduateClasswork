import java.io.*;
import java.util.*;
/**
 * Write a description of class ArrayWordList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrayWordList
{
        public static void main (String[] args) {
        ArrayList <String> w  = new ArrayList<String>();
        Scanner reader=null;
        try { reader = new Scanner(new File("EnglishWordList.txt"));
           }
            catch ( FileNotFoundException ex)
            {System.out.println(ex+"file not found ");
            }
            while (reader.hasNext()){
        String str = reader.nextLine();
        System.out.println(str);
        w.add(str);
        }
   }
}
