using System;

namespace Grade_Calculation
{
	class MainClass
	{
		// Julie Leong and Ian Davis

		static void Main ()
		{
			Console.WriteLine ("Enter weights for each category below as percentage of the final grade:");
			Console.WriteLine ("Exams:");
			string aString = Console.ReadLine ();
			double a = double.Parse (aString);
			Console.WriteLine ("Labs:");
			string bString = Console.ReadLine ();
			double b = double.Parse (bString);
			Console.WriteLine ("Homework:");
			string cString = Console.ReadLine ();
			double c = double.Parse (cString);
			Console.WriteLine ("Projects:");
			string dString = Console.ReadLine ();
			double d = double.Parse (dString);
			Console.WriteLine ("Participation:");
			string eString = Console.ReadLine ();
			double e = double.Parse (eString);
			double sum = a + b + c + d + e;
			Console.WriteLine ("The weights add up to " + sum); 
			if (sum != 100) {
				Console.WriteLine ("Your weights add to {0}, not 100.", sum);
				Console.WriteLine ("The program is now ending.");
				return;
			}
			Console.WriteLine ("Enter grade in decimal for each category below:");
			Console.WriteLine ("Exams: ");
			string uString = Console.ReadLine ();
			double u = double.Parse (uString);
			Console.WriteLine ("Labs: ");
			string vString = Console.ReadLine ();
			double v = double.Parse (vString);
			Console.WriteLine ("Homework: ");
			string wString = Console.ReadLine ();
			double w = double.Parse (wString);
			Console.WriteLine ("Projects: ");
			string xString = Console.ReadLine ();
			double x = double.Parse (xString);
			Console.WriteLine ("Participation: ");
			string yString = Console.ReadLine ();
			double y = double.Parse (yString);
			
			double ExamScore, LabScore, HomeworkScore, ProjectsScore, ParticipationScore;
			ExamScore = a * u;
			LabScore = b * v;
			HomeworkScore = c * w;
			ProjectsScore = d * x;
			ParticipationScore = e * y;
			
			double sum2 = ExamScore + LabScore + HomeworkScore + ProjectsScore + ParticipationScore;
			double FinalScore = sum2/100.0;
			
			Console.WriteLine ("Your grade in the class is {0}%.", FinalScore);
			Console.WriteLine ("Your letter grade is {0}.", LetterGrade(FinalScore));
					}
		
		static string LetterGrade (double score)
		{
			string letter;
			if (score >=97){
				letter = "A+";
			}
			else if (score >=93){
					letter = "A";
				}
				else if (score >=90){
						letter = "A-";
					}
					else if (score >=87){
							letter = "B+";
						}
						else if (score >=83){
								letter = "B";
							}
							else if (score >=80){
									letter = "B-";
								}
								else if (score >=77){
										letter = "C+";
									}
									else if (score >=73){
											letter = "C";
										}
										else if (score >=70){
												letter = "C-";
											}
											else if (score >=67){
													letter = "D+";
												}	
												else if (score >=63){
														letter = "D";
													}
													else if (score >=60){
															letter = "D-";
														}
														else {
															letter = "F";
														}
														return letter;
													}
													
												}
											}
										