import java.util.*;

public class Editor 
{
     public final static char COMMAND_START = '$';

     public final static String INSERT_COMMAND = "$Insert";

     public final static String DELETE_COMMAND = "$Delete";

     public final static String LINE_COMMAND = "$Line";

     public final static String DONE_COMMAND = "$Done";

     public final static String BAD_LINE_MESSAGE =
        "Error: a command should start with " + COMMAND_START + ".\n";

     public final static String BAD_COMMAND_MESSAGE =
        "Error: not one of the given commands.\n";

     public final static String INTEGER_NEEDED =
        "Error: The command should be followed by a blank space, " +
        "\nfollowed by an integer.\n";

     public final static String TWO_INTEGERS_NEEDED =
        "Error: The command should be followed by a blank space, " +
        "\nfollowed by an integer, followed by a blank space, " +
        "followed by an integer.\n";

     public final static String FIRST_GREATER =
        "Error: the first line number given is greater than the second.\n";

     public final static String FIRST_LESS_THAN_ZERO =
        "Error: the first line number given is less than 0.\n";

     public final static String SECOND_TOO_LARGE =
        "Error: the second line number given is greater than the " +
        "\nnumber of the last line in the text.\n";

     public final static String M_LESS_THAN_ZERO =
        "Error: the number is less than 0.\n";

     public final static String M_TOO_LARGE =
        "Error: the number is larger than the number of lines in the text.\n";

     public final static String LINE_TOO_LONG =
        "Error: the line exceeds the maximum number of characters allowed, ";

     public final static int MAX_LINE_LENGTH = 75;


     protected LinkedList<String> text;

     protected ListIterator<String> current;

     protected boolean inserting;


     /**
      *  Initializes this Editor object.
      *
      */
     public Editor() 
     {
         text = new LinkedList<String>();
         current = text.listIterator();
         inserting = false;
     } // default constructor


     /**
      *  Intreprets whether a specified line is a legal command, an illegal command
      *  or a line of text.
      *
      *  @param s - the specified line to be interpreted.
      *
      *  @return the result of carrying out the command, if s is a legal command, and
      *                return null, if s is a line of text or a command that does
      *                not return a value.
      *
      *  @throws RunTimeException - if s is an illegal command; the argument 
      *                 indicates the specific error.
      *
      */ 
     public String interpret (String s) 
     {
         // throw new OutOfMemoryError();
       
         Scanner sc = new Scanner (s);

         String command;

         if (s.length() == 0 || s.charAt (0) != COMMAND_START)  
             if (inserting)
                 insert (s);  
             else 
                 throw new RuntimeException (BAD_LINE_MESSAGE);
         else 
         {
                command = sc.next();
                if (command.equals (INSERT_COMMAND))
                    inserting = true;
                else 
                {
                    inserting = false;
                    if (command.equals (DELETE_COMMAND))
                        tryToDelete (sc);
                    else if (command.equals (LINE_COMMAND))
                        tryToSetCurrentLineNumber (sc);
                    else if (command.equals (DONE_COMMAND))
                        return done();
                    else
                        throw new RuntimeException (BAD_COMMAND_MESSAGE);
             } // command other than insert
         } // a command  
         return null;              
     } // method interpret


     /**
      *  Deletes the lines specified by the given line numbers, unless what follows
      *  $Delete is something other than two integers in the correct range.
      *
      *  @param sc - the Scanner object that scans the rest of the line after $Delete.     
      *
      *  @throws RunTimeException - if what follows $Delete does not consist of two
      *          integers, or if those integers are not in the correct range (namely,
      *          0 <= first integer <= second integer <= last line number in text).
      *
      */ 
     protected void tryToDelete (Scanner sc) 
     {
         int m = 0,
             n = 0;
         
         try 
         {
             m = sc.nextInt();
             n = sc.nextInt();              
         }
         catch (RuntimeException e) 
         {
             throw new RuntimeException (TWO_INTEGERS_NEEDED);
         } // not enough integer tokens       
        delete (m, n);   
     } // method tryToDelete

     
     /**
      *  Sets the current line as specified by the given line number, unless what follows
      *  $Line is something other than an integer in the correct range.
      *
      *  @param sc - the Scanner object that scans the rest of the line after $Line.     
      *
      *  @throws RunTimeException - if what follows $Line does not consist of an
      *          integer, or if that integer is not in the correct range (namely,
      *          0 <= integer <= number of lines in text).
      *
      */ 
     protected void tryToSetCurrentLineNumber (Scanner sc) 
     {
         int m = 0;
         
         try 
         {
             m = sc.nextInt();
         } // try
         catch (RuntimeException e) 
         { 
             throw new RuntimeException (INTEGER_NEEDED);
         } // no next token or token not an integer 
         setCurrentLineNumber (m);
     } // method tryToSetCurrentLineNumber


     /**
      *  Inserts a specified line in front of the current line.
      *
      *  @param s - the line to be inserted.
      *
      *  @throws RunTimeException - if s has more than MAX_LINE_LENGTH 
      *                 characters.
      *
      */
     protected void insert (String s) 
      {
           if (s.length() > MAX_LINE_LENGTH)
               throw new RuntimeException (LINE_TOO_LONG + 
                                           MAX_LINE_LENGTH + "\n");
           current.add (s);
     } // insert


  
     /**
      *  Deletes a specified range of lines from the text, and sets the current line
      *  to be the line after the last line deleted.
      *
      *  @param m - the beginning index of the range of lines to be deleted.
      *  @param n - the ending index of the range of lines to be deleted.
      *
      *  @throws RunTimeException - if m is less than 0 or if n is less than m or if
      *                 n is greater than or equal to the number of lines of text.
      *
      */ 
     protected void delete (int m, int n) 
     {
         if (m > n)         
              throw new RuntimeException (FIRST_GREATER);        
         if (m < 0)
              throw new RuntimeException (FIRST_LESS_THAN_ZERO);
         if (n >= text.size())
              throw new RuntimeException (SECOND_TOO_LARGE);
         current = text.listIterator (m);
         for (int i = m; i <= n; i++) 
         {
             current.next();
             current.remove ();
         } // for
     } // method delete



     /**
      *  Makes a specified index the index of the current line in the text.
      *
      *  @param m - the specified index of the current line.
      *
      *  @throws RunTimeException - if m is less than 0 or greater than or equal to
      *                 the number of lines of text.
      *
      */ 
     protected void setCurrentLineNumber (int m) 
     {
         if (m < 0)
             throw new RuntimeException (M_LESS_THAN_ZERO);
         if (m > text.size())
             throw new RuntimeException (M_TOO_LARGE);
         current = text.listIterator (m);
     } // method setCurrentLineNumber


     /**
      *  Returns the final version of the text.
      *
      *  @return the final version of the text.
      *
      */
     protected String done() 
     {        
         String s = "";

         ListIterator<String> itr = text.listIterator();

         while (itr.hasNext())
             if (itr.nextIndex() == current.nextIndex())
                  s = s + ">  " + itr.next() + '\n';
             else
                  s = s + "   " + itr.next() + '\n';
         if (!current.hasNext())
             s = s + ">  " + '\n';
         return s;
     } // method done

} // class Editor
