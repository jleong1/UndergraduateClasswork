using System;
namespace IntroCS
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			string input = UIF.PromptLine("Please enter a string:");
			ShowLength(input);			
		}
		public static void ShowLength (string a)
		{
			Console.WriteLine ("The length of the string is {0}.", a.Length);
		}
	}
}
