import java.io.*;
import java.util.*;

public class EditorUser
{
    public final String FINAL_MESSAGE = "\n\n***********************\nHere is the final text:\n";
    
    public static void main (String[] args) 
    {
        new EditorUser().run();
    } // main method
    
    public void run()
    {                  
        final String IN_FILE_PROMPT =
              "\n\nPlease enter the path for the input file: ";

        final String OUT_FILE_PROMPT =
              "\n\nPlease enter the path for the output file: ";

        final String IO_EXCEPTION_MESSAGE = "The file was not found.\n\n";

        Scanner keyboardScanner = new Scanner (System.in),        
                fileScanner = null;

        PrintWriter printWriter = null;   
    

        String inFilePath,
               outFilePath;

        boolean pathsOK = false;

        while (!pathsOK)
        {
            try
            {
                System.out.print (IN_FILE_PROMPT);
                inFilePath = keyboardScanner.nextLine();
                fileScanner = new Scanner (new File (inFilePath));
                System.out.print (OUT_FILE_PROMPT);
                outFilePath = keyboardScanner.nextLine();
                printWriter = new PrintWriter (new FileWriter (outFilePath));                
                pathsOK = true;
            } // try
            catch (IOException e)
            {
                System.out.println (IO_EXCEPTION_MESSAGE + e);
            } // catch I/O exception
        } // while
        editText (fileScanner, printWriter);
        printWriter.close();
    } // method run


    /**
     * Creates the output file by performing the input-file commands.
     * 
     * @param fileScanner - the Scanner over the input file.
     * @param printWriter - the PrintWriter for the output file.
     *     
     */
    public void editText (Scanner fileScanner, PrintWriter printWriter)
    {                
        Editor editor = new Editor();
        
        String line = new String(),
               result = new String();

        while (true)
        {
            try
            {      
                line = fileScanner.nextLine();                
                printWriter.println (line);
                result = editor.interpret (line);
             } // try
             catch (RuntimeException e)
             {
                 printWriter.println (e);
             } // catch RuntimeException             
             if (line.equals (Editor.DONE_COMMAND))
             {
                 printWriter.println (FINAL_MESSAGE + result);
                 break;
             } // if line is done-command
          } // while          
    } // method editText    

} // class EditorUser
