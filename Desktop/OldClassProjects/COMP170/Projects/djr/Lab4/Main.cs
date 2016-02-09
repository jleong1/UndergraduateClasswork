using System;
using IntroCS;
namespace Lab4
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			Game ();
		
			Game1 ();

			Game2 ();

			int bound = UIF.PromptInt ("Please enter the secret bound or 0 to quit: ");
			while (bound != 0) {
				Game3 (bound);
				Game4 (bound);
			}
		}

		public static void Game ()
		{
			int secret = 42;
			int guess = UIF.PromptInt ("Guess a number! ");
			
			while (guess != secret) {
				Console.WriteLine ("Wrong!");
				guess = UIF.PromptInt ("Please Try again:");
			}
			Console.WriteLine ("You have succeeded!");

		}

		public static void Game1 ()
		{
			int secret = 42;
			int guess = UIF.PromptInt ("Guess a number! ");

			while (guess != secret) {

				if (guess > secret) {
					Console.WriteLine ("Lower!");
				} 

				if (guess < secret) {
					Console.WriteLine ("Higher!");
				}

				guess = UIF.PromptInt ("Please try again:");
			}

			Console.WriteLine ("You have succeeded!");
		}

		public static void Game2()
		{
			int big = 100;
			Console.WriteLine ("In this game you will guess for a number less than {0}.", big);
			Random r = new Random ();
			int secret = r.Next(1, big);
			int guess =  UIF.PromptInt("Guess a number! ");

			while (guess != secret) {
				
				if (guess > secret) {
					Console.WriteLine ("Lower!");
				} 

				if (guess < secret) {
					Console.WriteLine ("Higher!");
				}
				
				guess = UIF.PromptInt ("Please try again:");
			}
			
			Console.WriteLine ("You have succeeded!");
		}

		static void Game3(int big)
		{
			Console.WriteLine ("In this game you will guess for a number less than {0}.", big);
			Random r = new Random ();
			int secret = r.Next(1, big);
			int guess =  UIF.PromptInt("Guess a number! ");
			while (guess != secret) {
				
				if (guess > secret) {
					Console.WriteLine ("Lower!");
				} 
				
				if (guess < secret) {
					Console.WriteLine ("Higher!");
				}
				
				guess = UIF.PromptInt ("Please try again:");
			}
			
			Console.WriteLine ("You have succeeded!");
		}

		static void Game4(int big)
		{
			Console.WriteLine ("In this game you will guess for a number less than {0}.", big);
			Random r = new Random ();
			int secret = r.Next(1, big);
			int guess =  UIF.PromptInt("Guess a number! ");
			int i = 1;
			while (guess != secret) {
				
				if (guess > secret) {
					Console.WriteLine ("Lower!");
				} 
				
				if (guess < secret) {
					Console.WriteLine ("Higher!");
				}
				
				guess = UIF.PromptInt ("Please try again:");
				i = i+1;
			}
			
			Console.WriteLine ("You have succeeded!");
			Console.WriteLine ("You won on guess {0}", i);
		}
				}
			}
