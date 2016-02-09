import java.util.*;

public class SpellChecker
{
    protected TreeSet<String> dictionarySet,
                              documentSet;

    /**
     *  Initializes this SpellChecker object.
     *
     */ 
    public SpellChecker()
    {
         dictionarySet = new TreeSet<String>();
         documentSet = new TreeSet<String>();
    } // default constructor
   
    /**
     *  Inserts a specified word into the dictionary of words.
     *  The worstTime(n) is O(log n), where n is the number of words in the
     *  dictionary of words.
     *
     *  @param word - the word to be inserted into the dictionary of words.
     * 
     *  @return a String representation of the dictionary.
     *
     *  @throws NullPointerException - if word is null.
     *  
     */
    public String addToDictionary (String word)
    {
         dictionarySet.add (word);
         return dictionarySet.toString();
    } // method addToDictionary

    /**
     *  Inserts all of the words in a specified line into the document of words.
     *  The worstTime(m) is O(log m), where m is the number of (unique) words
     *  in the document of words.
     *
     *  @param line - the line whose words are added to the document of words.
     *
     *  @throw NullPointerException - if line is null.
     *
     */
    public String addToDocument (String line)
    {
         final String DELIMITERS = "[^a-zA-Z]+";

         Scanner sc = new Scanner (line).useDelimiter (DELIMITERS);

         String word;

         while (sc.hasNext())
         {
             word = sc.next().toLowerCase();
             documentSet.add (word);
         } // while line has more tokens
         return documentSet.toString();
    } // method addToDocument 

    /**
     *  Determines all words that are in the document but not in the dictionary.
     *  The worstTime(m, n) is O(m log n), where m is the number of words
     *  in the document, and n is the number of words in the dictionary.
     *
     *  @return a LinkedList consisting of all the words in the document that
     *                are not in the dictionary.
     *
     */
    public LinkedList<String> compare()
    {
         LinkedList<String> misspelled = new LinkedList<String>();
        
         for (String word : documentSet)        
             if (!dictionarySet.contains (word))
                  misspelled.add (word);
         return misspelled;
    } // method compare

} // class SpellChecker


 

 
