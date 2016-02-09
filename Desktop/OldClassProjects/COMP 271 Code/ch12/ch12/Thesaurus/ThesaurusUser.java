import java.util.*;

import java.io.*;

public class ThesaurusUser
{
    public static void main (String[] args)
    {
        new ThesaurusUser().run();
    } // method main
    
    public void run()
    {        
       final String THESAURUS_FILE_PROMPT = 
           "\nPlease enter the path for the thesaurus file: ";
       
       final String REQUEST_FILE_PROMPT = 
           "\nPlease enter the path for the file with the words " +
           "whose synonyms are requested: ";

       final String SYNONYM_FILE_PROMPT = 
           "\nPlease enter the path for the file that will " +
           "hold the synonyms of each word in the request file: ";
       
       final String NO_INPUT_FILE_FOUND_MESSAGE =
           "Error: there is no file with that path.\n\n";
       
       Thesaurus thesaurus = new Thesaurus();
       
       Scanner keyboardScanner = new Scanner (System.in),
               thesaurusFileScanner,
               requestFileScanner;
       
       PrintWriter synonymFileWriter;

       String thesaurusFilePath,
              requestFilePath,
              synonymFilePath;
                   
       boolean pathsOK = false;

       while (!pathsOK)
       {
           try
           {
               System.out.print (THESAURUS_FILE_PROMPT);
               thesaurusFilePath = keyboardScanner.nextLine();
               thesaurusFileScanner = new Scanner (new File (thesaurusFilePath));
               while (thesaurusFileScanner.hasNext())                     
                   thesaurus.add (thesaurusFileScanner.nextLine()); 
               
               System.out.print (REQUEST_FILE_PROMPT);
               requestFilePath = keyboardScanner.nextLine();
               requestFileScanner = new Scanner (new File (requestFilePath));
               
               System.out.print (SYNONYM_FILE_PROMPT);
               synonymFilePath = keyboardScanner.nextLine();
               synonymFileWriter = new PrintWriter (new BufferedWriter
                      (new FileWriter (synonymFilePath)));
                                                     
               pathsOK = true;
               findSynonyms (thesaurus, requestFileScanner, synonymFileWriter);
               synonymFileWriter.close();              
           } // try
           catch (IOException e)
           {
               System.out.println (e);
           } // catch
       } // while !pathsOK      
    } // method run

    
    /**
     *  Outputs the synonyms of the words in the file scanned to a specified file.
     *  The worstTime(n, m) is O(m log n), where n is the number of lines in 
     *  the thesaurus, and m is the number of words in the file scanned.
     *
     *  @param thesaurus - the thesaurus of words and synonyms.
     *  @param requestFileScanner - the Scanner over the file that holds the
     *         words whose synonyms are requested.
     *  @param synonymFileWriter - the FileWriter for the file that will hold
     *         the synonyms of the words in the request file.
     * 
     */ 
    public void findSynonyms (Thesaurus thesaurus, Scanner requestFileScanner,
                              PrintWriter synonymFileWriter) 
    {        
        final String WORD_NOT_FOUND_MESSAGE =
            " does not appear in the thesaurus.";

        final String SYNONYM_MESSAGE = "Here are the synonyms of ";
        
        String word;

        LinkedList<String> synonymList;
                
        while (requestFileScanner.hasNext())
        {                
            word = requestFileScanner.next();            
            synonymList = thesaurus.getSynonyms (word);
            if (synonymList == null)
                synonymFileWriter.println (word + WORD_NOT_FOUND_MESSAGE);
            else            
                synonymFileWriter.println (SYNONYM_MESSAGE + word + 
                        ": " + synonymList);                   
        } // while
    } // method findSynonyms
   
} // class ThesaurusUser
