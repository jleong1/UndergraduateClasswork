using System;

namespace Histogram
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			Console.WriteLine (Histogram(new int[]{2, 0, 3, 5, 3, 5}, 0, 5));
		}
		// Return a histogram array counting repetitions of values
		//  start through end in array a.  The count for value start+i
		//  is in index i of the returned array.  For example:
		//  Histogram(new int[]{2, 0, 3, 5, 3, 5}, 0, 5) returns
		//  a new array containing {1, 0, 1, 2, 0, 2}.
		public static int[] Histogram (int[] a, int start, int end)
		{
			for(int i = 0; i < a.Length; i++){
		}
	}
}
			   