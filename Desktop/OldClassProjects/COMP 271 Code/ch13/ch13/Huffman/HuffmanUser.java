import java.util.*;

import java.io.*;

public class HuffmanUser
{
    public static void main (String[] args)
    {
        new HuffmanUser().run();
    } // method main
            
    
    public void run()
    {
        final String IN_FILE_PROMPT =
            "\nPlease enter the path for the input file: ";

        final String OUT_FILE_PROMPT =
            "\nPlease enter the path for the output file: ";               

        Huffman huffman = new Huffman();

        PrintWriter printWriter = null;

        Scanner keyboardScanner = new Scanner (System.in),
                      fileScanner = null;                             
        
        String inFilePath = null,
                  outFilePath,
                  line;

        boolean pathsOK = false;

        while (!pathsOK)
        {
            try
            {
                 System.out.print (IN_FILE_PROMPT);
                 inFilePath = keyboardScanner.nextLine();
                 fileScanner = new Scanner(new File (inFilePath));                
                 System.out.print (OUT_FILE_PROMPT);
                 outFilePath = keyboardScanner.nextLine();
                 printWriter = new PrintWriter (new FileWriter (outFilePath));
                 pathsOK = true; 
            } // try
            catch (IOException e)
            {
                System.out.println (e);
            } // catch
        } // while !pathOK
        createEncoding (fileScanner, huffman);
        saveEncodedMessage (printWriter, inFilePath, huffman);
    } // method run

    /**
     *  Creates the Huffman encoding by scanning over a file to be encoded.
     *  The worstTime(n) is O(n).
     *   
     *  @param fileScanner – a scanner over the file to be encoded.
     *  @param huffman – an instance of the Huffman class.
     *  
     * @return - a String consisting of each character and its encoding
     *     
     */
    public String createEncoding (Scanner fileScanner, Huffman huffman)
    {
        String line;
       
        while (fileScanner.hasNextLine())
        {
            line = fileScanner.nextLine();            
            huffman.updateFrequencies (line);
        } // while
        fileScanner.close(); // re-opened in saveEncodedMessage
        huffman.createPQ();
        huffman.createHuffmanTree();
        huffman.calculateHuffmanCodes();   
        return huffman.getCodes();           
    } // method createEncoding

   /**
    *  Saves the Huffman codes and the encoded message to a file.
    *  The worstTime(n) is O(n).
    *  
    *  @param printWriter - the PrintWriter object that holds the Huffman codes 
    *                      and the encoded message.
    *  @param inFilePath - the String object that holds the path for the file
    *                      that contains the original message.
    *  @param huffman – an instance of the Huffman class.       
    *
    */    
    public void saveEncodedMessage (PrintWriter printWriter, String inFilePath, 
                                                              Huffman huffman) 
    {        
        String line;

        try
        {
            printWriter.print (huffman.getCodes());
            printWriter.println ("**"); // to separate codes from encoded message
            Scanner fileScanner = new Scanner (new File (inFilePath));

            while (fileScanner.hasNextLine())
            {
                line = fileScanner.nextLine();                
                printWriter.println (huffman.getEncodedLine (line));
            } // while
            printWriter.close();
        } // try
        catch (IOException e)
        {
            System.out.println (e);
        } // catch IOException
    } // method saveEncodedMessage

} // class HuffmanUser   
      
      