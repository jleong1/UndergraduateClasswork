using System;

namespace IntroCS
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			double balance = UIF.PromptDouble ("Please enter initial balance: ");
			double percentage = UIF.PromptDouble ("Please enter a percentage as a decimal: ");
			double desired_balance = UIF.PromptDouble ("Please enter desired balance: ");
	Console.WriteLine("The years to earn {0} is {1}.", desired_balance, BankAccount(balance, percentage, desired_balance);
		}
		public static double BankAccount(double balance, double percentage, double desired_balance)
		{
			int years = 0;
			while (balance <= desired_balance) {
				double new_balance = balance * (1 + percentage);
					years++;
					Console.WriteLine("The balance for year {0} is {1}.", years, new_balance);
			}
				return years;
		}
	}
}
