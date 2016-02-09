public static void Main (string[] args)
{	
	string input = UIF.PromptLine("Please enter a string:");
	ShowLength(input);
	SentenceType ();
	LastFirst1();
	LastFirst2();
}
public static void ShowLength (string a)
{
	Console.WriteLine ("The length of the string is {0}.", a.Length);
}
public static void SentenceType()
{
	string input2 = UIF.PromptLine("Please enter a string:");
	Console.ReadLine(input)
	if(input2[input2.Length - 1] == "."){
		Console.WriteLine ("The string is a declarative sentence.");
	}
	else{
		if(input2[input2.Length - 1] == "!"){
			Console.WriteLine ("The string is an exclamatory sentence.");
		}
		else{
			Console.WriteLine("The string is an interrogative sentence.");
		}
	}
	public static void LastFirst1()
	{
		string input3 = UIF.PromptLine("Please enter a name:");
		int space = IndexOf(" ");
		string first = input3.Substring(0,space);
		string last = input3.Substring(space);
		Console.WriteLine("{0}, {1}", last, first);
	}
	public static void LastFirst2()
	{
		string input4 = UIF.PromptLine("Please enter a name:");
		int space = IndexOf(" ");
		if(space == -1){
			Console.WriteLine (input4);
			{
				else {
					LastFirst1(input4);
				}
			}
		}
	}
	
