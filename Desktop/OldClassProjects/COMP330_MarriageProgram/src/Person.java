/*
 * Made a person struct in order for a person to contain certain information.
 * A person has a name, age, gender, and marriage status
 * @author: Julie Leong
 * IDE used: Eclipse
 * @date: 2/5/2015
 */
public class Person {
	private String name;
	private int age;
	private String gender;
	private String Mstatus;
	
	public Person(String name, int age, String gender, String Mstatus){
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.Mstatus = Mstatus;
	}
	
	//gets name of person
	public String getName(){
		return name;
	}
	
	//gets age of person 
	public int getAge(){
		return age;
	}
	
	//gets gender of person
	public String getGender(){
		return gender;
	}
	
	//gets marital status of a person
	public String getStatus(){
		return Mstatus;
	}
	
	//changes marital status of a person
	public String changeStatus(String status){
		this.Mstatus = status;
		return status;
	}
	
	//prints a person's information
	public String printInfo(Person k){
		String info = "Name: " + k.getName() + "  Age: " + k.getAge() + "  Sex: " + k.getGender() + "  Status: " + k.getStatus();
		return info;
	}
	
}
