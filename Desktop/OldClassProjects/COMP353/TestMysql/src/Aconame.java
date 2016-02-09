import java.sql.*;
import java.io.*;
public class Aconame {
	 public static void main (String args [])
			 throws SQLException, IOException {

		    try {
		// The newInstance() call is a work around for some
		// broken Java implementations
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
		// handle the error
		}

		 //Define URL of database server for
		 // database named mysql on the localhost
		 // with the default port number 3306.
		 String url = "jdbc:mysql://codd.cs.luc.edu/jleong1_a8";

		 //Get a connection to the database for a
		 // user named root with a blank password.
		 // This user is the default administrator
		 // having full privileges to do anything.
		 Connection con = DriverManager.getConnection(url,"jleong1", "p32872");
		    Statement stmt = con.createStatement ();
		    String path = "'C:/Users/Julie Leong/Desktop/aconame.txt'";
		    String query = "load data local infile " + path +
		    " into table Aconame " + "fields terminated by ',' " + 
		    "enclosed by " + "''" + "lines terminated by '\n' (Assignee,Compname)";
		    stmt.executeUpdate(query);
		
		    
		    Aconame coname = new Aconame();
		    int assignId = Integer.parseInt(readEntry("Enter an assignee Id: "));
		    String company = coname.findAssignee(assignId, con);
		    System.out.println("Company name: " +company);
		    con.close();
		    
		  }
	 
	 public String findAssignee(int assignID, Connection con) throws SQLException, IOException{
		 String company ="";
		 Statement stmt = con.createStatement ();
		 String query = "select Compname from Aconame where ID=" +assignID;
		 ResultSet rset = stmt.executeQuery(query);
		 while(rset.next()){
		 company = rset.getString(1);
		 }
		 con.close();
		 return (company);
	 }
		  //readEntry function -- to read input string

	 static String readEntry(String prompt) {
		     try {
		       StringBuffer buffer = new StringBuffer();
		       System.out.print(prompt);
		       System.out.flush();
		       int c = System.in.read();
		       while(c != '\n' && c != -1) {
		         buffer.append((char)c);
		         c = System.in.read();
		       }
		       return buffer.toString().trim();
		     } catch (IOException e) {
		       return "";
		       }
		   }
}
