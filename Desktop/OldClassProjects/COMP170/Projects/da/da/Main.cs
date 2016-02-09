using System;

namespace da
{
	class MainClass
	{
		static string ConvertName(string fullName)
		{
			string part = " ";
			string lastName = fullName.Substring(fullName.IndexOf(part));
			string firstMiddle = fullName.Substring (0, fullName.IndexOf(part) + 1); 
			string separator = " , "; 
			string result = lastName + separator + firstMiddle;
			return result;
		}
		static void Main ()
		{
			string president = "Barack H. Obama";
			string presidentLastFirst = ConvertName (president);
			Console.WriteLine (presidentLastFirst);
		}
	}
}
