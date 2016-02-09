using System;

namespace IntroCS
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			int earned_credits = UIF.PromptInt ("How many credits have you earned? ");
			if (earned_credits >= 120) {
				Console.WriteLine ("You have earned the required amount of credits needed for graduations/nHurrary!");
			} else {
				Console.WriteLine ("You are not ready to graduate.");
			}

		}
	}
}
