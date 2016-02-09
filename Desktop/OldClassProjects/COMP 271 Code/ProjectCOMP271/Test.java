import java.util.*;
import java.io.*;
/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test 
{
    public static void main(String[] args){
        Scanner reader=null;
        LinkedList<String> content = new LinkedList<String>();
        try { reader = new Scanner(new File("WrongText.txt"));
           }
            catch ( FileNotFoundException ex)
            {System.out.println(ex+"file not found");
            }
        while (reader.hasNext()){
                String str = reader.nextLine();
                str.replaceAll("[\\[\\]_:\"'`?;0-9;()-/.,*! ]", "").toLowerCase();
                content.add(str);
            }

        }
}
