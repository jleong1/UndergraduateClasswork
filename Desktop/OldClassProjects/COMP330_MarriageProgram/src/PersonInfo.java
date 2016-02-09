import java.util.Scanner;
/*PersonInfo is the class where main program is executed
 * IDE used: Eclipse
 * @author: Julie Leong
 * @date: 2/5/2015
 */
public class PersonInfo {

	public static void main (String[] args){

		Scanner reader = new Scanner(System.in);
		SystemActions newMarriage = new SystemActions();//instantiate SystemActions in order to use functions from System Actions
	
		System.out.println("The following questions are used to enter information about a person.");
		
		//Haven't figured out a good way to implement a way to warn people if they enter something unexpected. so for a 
		// warning, I mention it in the beginning that a person must answer questions the correct way
		System.out.println("Would you like to a)enter a person b)marry someone?  or c) see a list of people in system.  Enter either 'a', 'b', or 'c'. Note you must enter 'a', 'b', or 'c' for the following questions that require 'a', 'b', or 'c'or system will break. Also, system is case sensitive.");
		String response = reader.next();
		
		//Use a switch case to do certain things depending on response of user
		switch(response){
		case "a": //enters information about a person
			while(response.equals("a")){
				newMarriage.askInfo();
				response = reader.next();
				}
			
		case "b": //attempts to marry people
			while(response.equals("b")){
				newMarriage.marryPeople();
				response = reader.next();

			}
		
		case "c": //prints all information in system, last thing done
			newMarriage.printInfo();
			break;
			}
		
		reader.close();
		}
	
}
