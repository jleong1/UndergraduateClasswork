import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*SystemActions is the actions necessary to enter information about a person, marry a person,
 * then later print information about a person 
 * IDE used: Eclipse
 * @author: Julie Leong
 * @date: 2/5/2015
 */

public class SystemActions {
	
	String name; //name of person 
	int age; //age of person
	String gender; //gender of person
	String Mstatus = "single"; //starting status of person, assuming that everyone entered to system is single
	Scanner reader = new Scanner(System.in); //new instantiation of scanner for reading input
	ArrayList <Person> people = new ArrayList<Person>(); //ArrayList holds information of different persons entered in system
	ArrayList<String> marriedPeople = new ArrayList<String>();// ArrayList has list of who is married to who
	Random rand = new Random(); // used to randomly match make people to their spouse
		
	//following function, askInfo, is a series of questions that pertain to a person, hence creating a person
	public void askInfo(){
		System.out.println("What is the first and last name of the person? For example John Smith.");
		name = reader.nextLine();
		
		System.out.println("What is the age of the person? For example, 19");
		age = Integer.parseInt(reader.nextLine());
		
		System.out.println("What is the gender of the person? Enter 'male' or 'female'.");
		gender = reader.nextLine();
		
		people.add(new Person(name, age, gender, Mstatus));
		System.out.println("Would you like to a)enter another person or b)marry someone? c) see a list of people in system?  Enter either 'a', 'b', or 'c'.");
	}
			
	//function marries people together
	public void marryPeople(){
		System.out.println("We will now randomly match two people together.");
		Person a = people.get(rand.nextInt((people.size()))); //randomly choose a person
		Person b = people.get(rand.nextInt((people.size()))); //randomly choose another person
		
		/*the following if statement exists to check marriage constraints, ex both persons are over 18, a person
		 * cannot be married to themself, and a person who is already married cannot be married again
		*/
		if(a.getAge()>=18 && b.getAge()>=18 && a!=b && a.getStatus() != "married" && b.getStatus() != "married"){
			String newCouple= String.format("%s is now married to %s", a.getName(),b.getName());
			a.changeStatus("married");//updates persons marriage status to married
			b.changeStatus("married");// updates persons marriage status
			marriedPeople.add(newCouple); //adds couple to marriedPeople list
			System.out.println(String.format(" %s and %s is now married.", a.getName(), b.getName()));
			
			System.out.println("Would you like to  b)marry someone someone else? or c) see a list of people in system?  Enter either 'b' or 'c'.");
			
		}else{
			System.out.println(String.format("Sorry we tried marrying %s and %s but one or both of them is not over the age of 18, or people chosen are not applicable to marriage",a.getName(),b.getName()));
			System.out.println("Would you like to b)marry someone else? or c) see a list of people in system?  Enter either 'b' or 'c'.");
			}
		}
			
	/*printInfo prints the list of people in system and prints the list of married people
	 * 
	 */
	public void printInfo(){
		System.out.println("");
		System.out.println("List of people in system.");
		for(Person k: people){
			System.out.println(k.printInfo(k));
		}
			
		System.out.println("");
		System.out.println("List of married people in system.");

		for(String marriage: marriedPeople){
			System.out.println(marriage);
	}
}
		

}
