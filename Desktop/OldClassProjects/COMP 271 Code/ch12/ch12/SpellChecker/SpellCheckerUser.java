import java.io.*;

import java.util.*;

public class SpellCheckerUser
{
    public static void main (String[] args)
    {
        new SpellCheckerUser().run();
    } // method main
    
    public void run()
    {   
        final int FILE_TYPES = 2;
             
        final String DICTIONARY = "dictionary";
       
        final String DOCUMENT = "document";

        final String ALL_CORRECT =
              "\n\nAll the words are spelled correctly.";

        final String MISSPELLED =
              "\n\nThe following words are misspelled:";
       
        SpellChecker spellChecker = new SpellChecker();
       
        Scanner keyboardScanner = new Scanner (System.in),
                fileScanner;

        String fileType = DICTIONARY,
               filePath;             

        for (int i = 0; i < FILE_TYPES; i++)
        {
            final String FILE_PROMPT = 
               "\nPlease enter the path for the " + fileType + " file: ";

            boolean pathOK = false;

            while (!pathOK)
            {
                try
                {
                    System.out.print (FILE_PROMPT);
                    filePath = keyboardScanner.nextLine();
                    fileScanner = new Scanner (new File (filePath));
                    pathOK = true;
                    if (fileType.equals (DICTIONARY))
                        while (fileScanner.hasNext())                                     
                           spellChecker.addToDictionary (fileScanner.nextLine());                            
                    else if (fileType.equals (DOCUMENT))
                        while (fileScanner.hasNext())                                     
                            spellChecker.addToDocument (fileScanner.nextLine());                         
                } // try
                catch (IOException e)
                {
                    System.out.println (e);
                } // catch 
            } // while
       
            fileType = DOCUMENT;
        } // for
         
        LinkedList<String> misspelled = spellChecker.compare();
        if (misspelled == null)
            System.out.println (ALL_CORRECT);
        else
            System.out.println (MISSPELLED + misspelled);
    } // method run
  
} // class SpellCheckerUser
 
