using System;

namespace IntroCS
{
	class MainClass
	{
		public static void Main (string[] args)
		{ 
			int i, total = 0;
			// what to make the condition?
			while ( i != 0){
				int sum = UIF.PromptInt("Please enter an integer: ");
				total += sum;
				i++;
			}
		}
	}
}
