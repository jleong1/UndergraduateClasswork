using System;

namespace IntroCS
{
	// Julie Leong and Ian Davis

	class MainClass
	{
		public static void Main (string[] args)
		{
			int exams, labs, homework, projects, participation, weightsum;
			do {
				Console.WriteLine ("Please enter the weights for the following");
				exams = UIF.PromptInt ("Exams: ");
				labs = UIF.PromptInt ("Labs: ");
				homework = UIF.PromptInt ("Homework: ");
				projects = UIF.PromptInt ("Projects: ");
				participation = UIF.PromptInt ("Participation: ");
				weightsum = exams + labs + homework + projects + participation;
				if (weightsum != 100) {
					Console.WriteLine ("Please enter the weights again.");
				}
			} while (weightsum != 100);

			double ExamScore, LabScore, HomeworkScore, ProjectsScore, ParticipationScore;

			double number = UIF.PromptDouble ("Please enter the number of grades for exams: ");
			ExamScore = exams * FindAverage ("exams", number);

			double number1 = UIF.PromptDouble ("Please enter the number of grades for labs: ");
			LabScore = labs * FindAverage ("labs", number1);

			double number2 = UIF.PromptDouble ("Please enter the number of grades for homework: ");
			HomeworkScore = homework * FindAverage ("homework", number2);

			double number3 = UIF.PromptDouble ("Please enter the number of grades for projects: ");
			ProjectsScore = projects * FindAverage ("projects", number3);

			double number4 = UIF.PromptDouble ("Please enter the number of grades for participation: ");
			ParticipationScore = participation * FindAverage ("participation", number4);
			
			double sum2 = ExamScore + LabScore + HomeworkScore + ProjectsScore + ParticipationScore;
			double FinalScore = sum2 / 100.0;
			
			Console.WriteLine ("Your grade in the class is {0}%.", FinalScore);
			Console.WriteLine ("Your letter grade is {0}.", LetterGrade (FinalScore));
		}

		public static double FindAverage (string name, double number)
		{
			double i = 0, grade, average, total = 0;
			while (i != number) {
				i ++;
				grade = UIF.PromptDouble ("Please enter the grade for " + name + " " + i + ": ");
				total += grade;
				Console.WriteLine ("Total points: {0}", total);
			}
			average = total / number;
			if (i == number) {
				Console.WriteLine ("Calculated average is {0}.", average);
			}
			return average;
		}
		
		public static string LetterGrade (double score)
		{
			string letter;
			if (score >= 97) {
				letter = "A+";
			} else if (score >= 93) {
				letter = "A";
			} else if (score >= 90) {
				letter = "A-";
			} else if (score >= 87) {
				letter = "B+";
			} else if (score >= 83) {
				letter = "B";
			} else if (score >= 80) {
				letter = "B-";
			} else if (score >= 77) {
				letter = "C+";
			} else if (score >= 73) {
				letter = "C";
			} else if (score >= 70) {
				letter = "C-";
			} else if (score >= 67) {
				letter = "D+";
			} else if (score >= 63) {
				letter = "D";
			} else if (score >= 60) {
				letter = "D-";
			} else {
				letter = "F";
			}
			return letter;
		}
	}
}




