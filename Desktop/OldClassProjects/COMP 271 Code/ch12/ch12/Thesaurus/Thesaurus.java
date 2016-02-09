import java.util.*;

public class Thesaurus
{
    protected TreeMap<String, LinkedList<String>> thesaurusMap;


    /** 
     *  Initializes this Thesaurus object.
     *
     */
    public Thesaurus() 
    {
          thesaurusMap = new TreeMap<String, LinkedList<String>>();
    } // default constructor


    /**
     *  Adds a specified line of synonyms to this Thesaurus object.
     *  The worstTime(n) is O(log n).
     *
     *  @param line - the specified line of synonyms to be added to this
     *                Thesaurus object.
     *
     *  @throws NullPointerException - if line is null.
     */
    public void add (String line) 
    {
        LinkedList<String> synonymList = new LinkedList<String>();

        Scanner sc = new Scanner (line);
  
        if (sc.hasNext())
        {
            String word = sc.next();

            while (sc.hasNext())
                synonymList.add (sc.next());  
            thesaurusMap.put (word, synonymList);
        } // if
    } // method add


    /** 
     *  Finds the LinkedList of synonyms of a specified word in this Thesaurus.
     *  The worstTime(n) is O(log n).
     *
     *  @param word - the specified word, whose synonyms are to be
     *                 returned.
     *
     *  @return the LinkedList of synonyms of word.
     *
     *  @throws NullPointerException - if word is null.
     */ 
    public LinkedList<String> getSynonyms (String word) 
    {
         return thesaurusMap.get (word);
    } // method getSynonyms

    
    /** 
     *  Returns a String representation of this Thesaurus object.
     *  The worstTime(n) is O(n).
     *     
     *  @return a String representation of this Thesaurus object in the 
     *          form [word1=[syn11, syn12, ...], word2=[syn21, syn22, ...], ...].
     *
     */ 
    public String toString()
    {
        return thesaurusMap.toString();
    } // method toString
} // class Thesaurus
