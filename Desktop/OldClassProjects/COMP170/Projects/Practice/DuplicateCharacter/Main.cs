using System;

namespace IntroCS
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			string s = UIF.PromptLine ("Enter a line: ");
			Console.WriteLine (HasDoubleChar (s))
		}
		/// If two consecutive characters in s are the same, return true.
		/// Return false otherwise.  Examples:
		/// HasDoubleChar("bigfoot") and HasDoubleChar("aaah!") are true;
		/// HasDoubleChar("treated") and HasDoubleChar("haha!") are false.
		static bool HasDoubleChar (string s)
		{
			int i = 0;
			while (i < s.Length-1) {
				if (s [i] != s [i++]) {
					i++;
				} else {
					return true;
				}
			}
				return false;
		}
	}
}
