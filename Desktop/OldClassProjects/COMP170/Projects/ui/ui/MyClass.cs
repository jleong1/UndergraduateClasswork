using System;
namespace IntroCS
{
	public class uif
	{
		public static void Main (string[] args)
		{
			string input = uif.PromptLine("Please enter a string:");
			ShowLength(input);
			
		}
		public static void ShowLength(string a)
		{
			Console.WriteLine("The length of the string is {0}." , a.length);
		}
	}
}