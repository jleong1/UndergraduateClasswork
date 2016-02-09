import java.io.*;
import java.util.*;
/**
 * Write a description of class WordStack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordStack
{
          public static void main (String[] args) {
        Stack <String> w  = new Stack<String>();
        Scanner reader=null;
        try { reader = new Scanner(new File("EnglishWordList.txt"));
           }
            catch ( FileNotFoundException ex)
            {System.out.println(ex+"file not found ");
            }
            while (reader.hasNext()){
        String str = reader.nextLine();
        System.out.println(str);
        w.push(str);
        }
   }
    }

