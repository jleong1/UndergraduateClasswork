using System;
using System.IO;
using System.Collections.Generic;

// Names: Julie Leong and Ian Davis

namespace IntroCS
{
   /// A main program to test the class BookList. 
   class TestBookList
   {
      /// Test BookList.
      public static void Main()
      {
         BookList books = new BookList();
         // ...
         books.Addbook(new Book("C# Yellow Book", "Rob Miles", 2011));
         books.Addbook(new Book("C# Software Solutions", "John Lewis", 2007));
         books.Addbook(new Book("A History of Modern Computing", "Paul E. Ceruzzi", 2003));
         books.Addbook(new Book("Universal History of Computing", "Georges Ifrah", 2001));
         books.Addbook(new Book("Tools for Thought", "Howard Rheingold", 2000));
         // Add more!
         // ...
         Console.WriteLine("The full list is:");
         books.PrintList();
         Console.WriteLine("\nHere is an example of the PrintTilesByAuthor function:");
         books.PrintTitlesByAuthor("John Lewis");
         Console.WriteLine("\nHere is an example of the PrintBooksInYears function:");
         books.PrintBooksInYears(2002, 2012);
         // Add more tests to fully test your code.
         // Make sure the correctness of the tests can be seen without reading
         // the source code -- comment on the meanings.
         // ...
      }
   }
}
