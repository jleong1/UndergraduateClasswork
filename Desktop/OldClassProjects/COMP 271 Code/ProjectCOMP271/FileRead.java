
/**
 * Write a description of class FileRead here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;
public class FileRead
{
    public static void main (String[] args) {
        Scanner reader=null;
        try { reader = new Scanner(new File("lines.txt"));
           }
            catch ( FileNotFoundException ex)
            {System.out.println(ex+"file not found");
            }
        while (reader.hasNext()){
                String str = reader.nextLine();
                System.out.println(str);
            }
        }
    }

