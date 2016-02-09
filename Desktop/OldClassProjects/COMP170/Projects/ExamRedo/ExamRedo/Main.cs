using System;

namespace ExamRedo
{
	class MainClass
	{
		static void Main ()
		{
			int [] practice = {4, 8, 5, 9, 1, 2, 10, 11};
			Console.WriteLine ("The number of evens in array practice is {0}", CountEven(practice));
			Console.WriteLine ("The number of odds in array practice is {0}", CountOdd(practice));
		}
		static int CountEven (int[] a)
		{
			int evens = 0;
			foreach (int val in a) {
				if (val % 2 == 0) {
					evens++;
				}
			}
			return evens;
		}
		static int CountOdd (int[]a)
		{
			int odds = a.Length - CountEven(a);
			return odds;
		}
	}
}
