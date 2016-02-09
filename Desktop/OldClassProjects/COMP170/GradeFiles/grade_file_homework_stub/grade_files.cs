using System;
using System.IO;

//Julie Leong and Ian Davis
// check bin folder to see report summary
namespace IntroCS
{
   class GradeFiles
   {
      public static void Main(string[] args)
      {
         string course = UIF.PromptLine("Enter course abbreviation: ");
         StreamReader reader = FIO.OpenReader("categories_" + course + ".txt");

         string category = reader.ReadLine();
         string[] categories = category.Split(',');
         for (int i = 0; i < categories.Length; i++) {
            categories[i] = categories[i].Trim();
         }

         string weights = reader.ReadLine().Trim();
         string[] weightAmount = weights.Split(',');
         double[] WeightNumbers = new double[weightAmount.Length];
         double[] weightTotal = {0};
         for (int i=0; i < WeightNumbers.Length; i++) {
            WeightNumbers[i] = double.Parse(weightAmount[i]);
         }
         for (int i=0; i < WeightNumbers.Length; i++) {
            weightTotal[0] += WeightNumbers[i];
         }
         
         string items = reader.ReadLine().Trim();
         string[] itemAmount = items.Split(',');
         double[] itemNumbers = new double[itemAmount.Length];
         for (int i=0; i < itemNumbers.Length; i++) {
            itemNumbers[i] = int.Parse(itemAmount[i]);
         }
        
         StreamWriter writer = new StreamWriter("report_" + course + ".txt");
         StreamReader reader2 = FIO.OpenReader("students_" + course + ".txt");
         while (!reader2.EndOfStream) {
            string StudentData = reader2.ReadLine().Trim();
            string[] StudentInfo = StudentData.Split(',');
            double percentage = Final(FinalCategory(CategoryAverage(RunningTotal(StudentInfo[0], course, categories), itemNumbers), WeightNumbers, weightTotal));
            string letter = LetterGrade(Final(FinalCategory(CategoryAverage(RunningTotal(StudentInfo[0], course, categories), itemNumbers), WeightNumbers, weightTotal)));
            writer.WriteLine("{0},{1} {2:F1} {3}", StudentInfo[1], StudentInfo[2], percentage, letter);
         }
         writer.Close();
         reader.Close();
      }

      static int codeIndex(string code, string[] categories)
      {
         for (int i = 0; i < categories.Length; i++) {
            if (categories[i].StartsWith(code)) {
               return i;
            }
         }
         return -1; 
      }

      static string LetterGrade(double score)
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

      static double[] RunningTotal(string studentID, string course, string[] categories)
      {
         StreamReader reader3 = FIO.OpenReader(studentID + course + ".data");
         double [] runningTotals = new double[categories.Length];
         while (!reader3.EndOfStream) {
            string data = reader3.ReadLine().Trim();
            string[] info = data.Split(',');
            runningTotals[codeIndex(info[0], categories)] += int.Parse(info[2]);
         }
         return runningTotals;
      }

      static double[] CategoryAverage(double[] totals, double[] itemNumbers)
      {
         double[] categoryAverage = new double[totals.Length];
         for (int i = 0; i <totals.Length; i++) {
            categoryAverage[i] = totals[i] / itemNumbers[i];
         }
         return categoryAverage;
      }

      static double []FinalCategory(double[] categoryAverage, double[] WeightNumbers, double[] weightTotal)
      {
         double[] FinalCategoryGrade = new double[categoryAverage.Length];
         for (int i = 0; i <categoryAverage.Length; i++) {
            FinalCategoryGrade[i] = (categoryAverage[i] * WeightNumbers[i]) / weightTotal[0];
         }
         return FinalCategoryGrade;
      }

      static double Final(double[]FinalCategoryGrade)
      {
         double Final = 0;
         for (int i = 0; i< FinalCategoryGrade.Length; i++) {
            Final += FinalCategoryGrade[i];
         }
         return Final;
      }
   }                      
}
