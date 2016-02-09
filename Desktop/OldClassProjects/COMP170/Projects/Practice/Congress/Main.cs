using System;

namespace IntroCS
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			int years = UIF.PromptInt ("How long have you lived in the US? ");
			int age = UIF.PromptInt ("How old are you? ");
			if (age >= 25 && years >= 7) {
				Console.WriteLine ("You are eligible to be a US Representative");
			} else if (age >= 30 && years >= 9) {
				Console.WriteLine ("You are elibible to be a US Senator and a US Representative.");
			} else {
				Console.WriteLine ("You are not eligible for a US congress");
			}
		}
	}
}
