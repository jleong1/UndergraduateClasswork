using System;

namespace IntroCS
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			int number = UIF.PromptInt ("Enter an integer: ");
			if (number > 0) {
				Console.WriteLine ("Positive");
			}
				else if (number == 0){
					Console.WriteLine ("0");
				}
					else{
						Console.WriteLine("Negative");
					}
		}
	}
}
