using System;

namespace IntroCS
{
	class LoopLab
	{
		
		static void Main () //testing routine
		{
			int n = UI.PromptIntInRange ("Enter a number of repetitions: ", 0, 20);
			string s = UI.PromptLine ("Enter a string: ");
			Console.Write ("Direct print {0} reps of {1}: ", n, s);
			PrintReps (s, n);
			Console.WriteLine ("\n\nPrint returned string of repeats: {0}",
			                  StringOfReps (s, n));
			Console.WriteLine ("{0}! is {1}.", n, Factorial (n));        
			PrintRectangle (3, 2, 'i', 'e');
			PrintRectangle (5, 1, ' ', 'B');
			PrintRectangle (0, 2, '-', '+');
			PrintTableBorders (3, 2, 4, 1);
			PrintTableBorders (2, 1, 6, 3);
		} 
		// PrintReps chunk
		/// Print n copies of s, end to end.
		/// For example PrintReps("Ok", 9) prints: OkOkOkOkOkOkOkOkOk
		static void PrintReps (string s, int n)
		{                                                      //body
			for (int i = 0; i != n; i++) {
				Console.Write ("{0}", s);
			}
		}
		//StringOfReps chunk    
		/// Return a string containing n copies of s, end to end.
		/// For example StringOfReps("Ok", 9) returns: "OkOkOkOkOkOkOkOkOk"
		static string StringOfReps (string s, int n)
		{                                                      // body
			string new_s = String.Empty;
			for (int i = 0; i != n; i++) {
				new_s += s;
			}
			return new_s; 
		}
		// Factorial chunk
		/// Return n! (n factorial: 1*2*3 *...* n if n >=1; 
		/// 0! is 1.).  For example Factorial(4) returns 1*2*3*4 = 24.
		static long Factorial (int n)
		{                                                     // body
			long x = 1, i = 2;
			while (i <= n) {
				x = x * i;
				i++;
			}
			return x;  // so it compiles
			//greatest possible value of n while using an int function is 19,
			//while using the long function, the value is 20
		}
		//PrintRectangle chunk
		// Print a filled rectange, where the filling is 
		// the specified number of columns and rows of the character inChar,
		// surrounded by a border made of the character edgeChar.
		// For example printRectangle(3, 2, 'i', 'e') prints
		//    eeeee
		//    eiiie
		//    eiiie
		//    eeeee
		static void PrintRectangle (int columns, int rows, 
		                           char inChar, char edgeChar)
		{                                                     // body
			for (int i = 0; i < columns + 2; i++) {
				Console.Write (edgeChar);
			}
			Console.WriteLine ();

			for (int i = 0; i < rows; i++) {
				Console.Write (edgeChar);
				for (int j = 0; j < columns; j++) {
					Console.Write (inChar);
				}
					for (int d = 0; d < 1 ; d++) {
						Console.Write (edgeChar);
					}
				Console.WriteLine ();
			}

			for (int i = 0; i < columns + 2; i++) {
				Console.Write (edgeChar);
			}
			Console.WriteLine ();
		}
		//PrintTableBorders chunk
		// For example PrintTableBorders(3, 2, 4, 1) prints
		//    +----+----+----+
		//    |    |    |    |
		//    +----+----+----+
		//    |    |    |    |
		//    +----+----+----+
		/// Print the borders of the cells of a table. 
		/// The borders divide the table into rows and columns.
		/// The blank space within a cell is width characters wide
		/// for height lines.
		/// The horizontal borders are dashes '-' and the vertical borders
		/// are vertical bars, '|', except that all intersections are '+'.
		static void PrintTableBorders (int columns, int rows, 
		                              int width, int height)
		{                                                     // body
			Console.WriteLine ("Extra Credit Not implemented");
		}
		
	}
}

