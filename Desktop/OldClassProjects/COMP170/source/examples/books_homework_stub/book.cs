using System;
using System.IO;
using System.Collections.Generic;

// Names: Julie Leong and Ian Davis
// Help from: 
/* Help details:

*/

namespace IntroCS
{

   /// A class that maintains information on a book. 
   public class Book
   {
      private String title;
      private String author;
      private int year;  // of publication

      public Book(String title1, String author1, int year1)
      { //code
         title = title1;
         author = author1;
         year = year1;
      }

      /// Return the title. 
      public String GetTitle()
      {  
         return title; //just so skeleton compiles
      }

      /// Return the author. 
      public String GetAuthor()
      {  
         return author; //just so skeleton compiles
      }

      /// Return the year of publication. 
      public int GetYear()
      {  // code!
         return year; //just so skeleton compiles
      }
                                                        
      /// Return a multi-line String labeling all Book information. 
      public override string ToString()
      {  
         string s = "Title: " + title + "\nAuthor: " + author + "\nYear: " + year + "\n";
         return s; //just so skeleton compiles
      }

      ////////////////////////////////////
      // Extra credit methods hereafter //
      ////////////////////////////////////
                                                  // extra credit Book chunk
      /// Construct a Book, taking data from reader.
      /// Read through three lines that contain the
      /// title, author, and year of publication, respectively.
      /// There may be an extra blank line at the beginning.
      /// If so ignore it.
      /// Nothing beyond the line with the year is read. 
      public Book(StreamReader reader)
      {  // code for extra credit!

      }
                                                  // extra credit IsEqual chunk
     // Return true if all the corresponding fields in this Book
      // and in aBook are equal.  Return false otherwise.  
      public bool IsEqual(Book aBook)
      {// code for extra credit

         return true; //so skeleton compiles
      }
   }
}
