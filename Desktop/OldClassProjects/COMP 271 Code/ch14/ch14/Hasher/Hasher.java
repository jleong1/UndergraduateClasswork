import java.util.*;

import java.io.*;

public class Hasher
{
    public static final String RESERVED_WORD = "reserved word";

    public static final String IDENTIFIER = "identifier";              
    
    public static void main (String[] args)
    {
        new Hasher().run();
    } // method main
    
    
    public void run()
    {    
        final String SOURCE_FILE_PROMPT =
            "\nPlease enter the path for the file that holds the source code: ";

        final String RESERVED_FILE_PROMPT =
            "\nPlease enter the path for the file that holds the reserved words: ";
        
        final String SYMBOL_TABLE_FILE_PROMPT =
            "\nPlease enter the path for the output file that will hold the symbol table: ";    
        
        HashMap<String, String> symbolTable= null ;

        Scanner keyboardScanner,
                reservedFileScanner = null,
                sourceFileScanner = null;

        PrintWriter symbolTableFileWriter = null;
           
        boolean pathsOK = false;
        
        while (!pathsOK)
        {
            try
            {                          
                keyboardScanner = new Scanner (System.in);
             
                System.out.print (RESERVED_FILE_PROMPT);
                String reservedFilePath = keyboardScanner.nextLine();             
                reservedFileScanner = new Scanner (new File (reservedFilePath)); 
             
                System.out.print (SOURCE_FILE_PROMPT);
                String sourceFilePath = keyboardScanner.nextLine(); 
                File sourceFile = new File (sourceFilePath);            
                sourceFileScanner = new Scanner (sourceFile);
                
                symbolTable = new HashMap<String, String> ((int)sourceFile.length());
             
                System.out.print (SYMBOL_TABLE_FILE_PROMPT);
                String symbolTableFilePath = keyboardScanner.nextLine();             
                symbolTableFileWriter = new PrintWriter (new FileWriter (symbolTableFilePath));  
                pathsOK = true;             
            } // try
            catch (Exception e) 
            { 
                System.out.println (e);
            } // catch
        } // while !pathsOK
        readReservedWords (reservedFileScanner, symbolTable);
        readSourceCode (sourceFileScanner, symbolTable);
        printSymbolTable (symbolTableFileWriter, symbolTable);
     }  // method run

 
    /**
     * Reads in the reserved words and posts them to the symbol table.
     * 
     * @param reservedFileScanner - a Scanner object for the file that 
     *                              contains the reserved words. 
     * @param symbolTable - the HashMap that holds the symbol table.
     */
     public void readReservedWords (Scanner reservedFileScanner, HashMap<String, String> symbolTable)                                    
     {                    
         String reservedWord;
                                
         while (reservedFileScanner.hasNextLine())
         {    
             reservedWord = reservedFileScanner.nextLine();                   
             symbolTable.put (reservedWord, RESERVED_WORD);
         } // while not at end of file        
     } // method readReservedWords


     /**
      * Reads the source file and posts identifiers to the symbol table.
      * The averageTime(n, m) is O(n), and worstTime(n, m) is O(n * n), where
      * n is the number of identifiers and m is the size of the symbol table.
      * 
      * @param sourceFileScanner - a Scanner object for the file that 
      *                              contains the source code.      
      */
     public void readSourceCode (Scanner sourceFileScanner, HashMap<String, String> symbolTable)                                 
     {        
         final String DELIMITERS = "[^a-zA-Z0-9$_]+";
          
         String line,
                word;
         
         int start,
             finish;

         boolean skip = false ;
                        
         while (sourceFileScanner.hasNextLine())
         {    
             line = sourceFileScanner.nextLine();
             line = line.trim();

             // Ignore lines beginning with "import".
             if (line.indexOf("import ") == 0)
                 continue;    // start another iteration of this loop

             // Ignore string literals.
             while ((start = line.indexOf ("\"")) >= 0)
             {
                 finish = line.indexOf("\"", 1 + start);
                 while (line.charAt (finish - 1) == '\\')
                     finish = line.indexOf ("\"", finish + 1);
                 line = line.substring(0, start) + line.substring(finish + 1);
             } // while line still has a string literal

             // Ignore // comments
             if ((start = line.indexOf("//")) >= 0)
                 line = line.substring(0, start);

             // Ignore any line between /* and */.
             if ((line.indexOf ("*/") == -1) && skip)
                 continue;

             // Remove substring up to */ if matching /* on earlier line.
             if ((start = line.indexOf("*/")) >= 0 && skip)
             {
                 skip = false;
                 line = line.substring (start + 2);
             } // first part of line a comment

             // Handle lines that have /*.
             while ((start = line.indexOf ("/*")) >= 0)
                 if ((finish = line.indexOf("*/", start + 2)) >= 0)
                     line = line.substring(0, start) + line.substring(finish + 2);
                 else
                 {
                     line = line.substring(0, start);
                     skip = true;
                 } // matching */ not on this line

                 // Tokenize line to find identifiers.
                 Scanner lineScanner = new Scanner(line).useDelimiter (DELIMITERS);
                 while (lineScanner.hasNext())
                 {
                     word = lineScanner.next();
                     if (!Character.isDigit(word.charAt(0)) &&
                                  !symbolTable.containsKey (word))
                         symbolTable.put(word, IDENTIFIER);
                 } // while not at end of line
         } // while not at end of file        
     } // method readSourceCode

 
     /**
       * Outputs the symbol table to a file.
       * The worstTime(n, m) is O(n + m), where n is the number of word symbols
       * and m is the size of the symbol table.
       * @param identifierFileWriter - a PrintWriter object for the file that 
       *                                 contains the symbol table.       
       */
     public void printSymbolTable (PrintWriter symbolTableFileWriter, HashMap<String, String> symbolTable)                                   
     {
         final String HEADING = "Here is the symbol table:\n";

         symbolTableFileWriter.println (HEADING);
         for (Map.Entry<String, String> entry : symbolTable.entrySet())             
                 symbolTableFileWriter.println (entry); 
         symbolTableFileWriter.close();
     } // method printSymbolTable

} // class Hasher

 
