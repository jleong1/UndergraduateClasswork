import java.sql.*;
import java.util.Scanner;
import java.io.*;

public class Wiki {
	   
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
	 String url = "jdbc:mysql://codd.cs.luc.edu/jleong1_final";

	 //Get a connection to the database for a
	 // user named root with a blank password.
	 // This user is the default administrator
	 // having full privileges to do anything.
	 Connection con = DriverManager.getConnection(url,"jleong1", "p32872");
	    Statement stmt = con.createStatement ();
	    
	    try {
	         File file = new File("Wiki.txt");
	         Scanner scanner = new Scanner(file);
	         while (scanner.hasNextLine()) {
	        	 String line = scanner.nextLine(); 
	        	 String[] words = line.split("\\s+");
	        	 char part = words[0].charAt(0);
	        	 switch(part){
	        	 case 0: part='#';
	        	 	break;
	        	 case 1: part='E';
	        	 	break;
	        	 case 2: part='T';
	        	 	break;
	        	 case 3: part='U';
	        	 ResultSet rset0 = stmt.executeQuery("select nominee_id from nominee");
	        	 if(rset0.getString(1)!=words[1].toString()){
	        	 stmt.executeUpdate("insert into nominee (nominee_id, username) values (" + words[1].toString()+", "+words[2].toString());
	        	 }
	        	 	break;
	        	 case 4: part='N';
	        	 stmt.executeUpdate("update nominee set nominator_id="+ words[1].toString()+"where nominee_id=last_insert_id()");
	        	 stmt.executeUpdate("update nominee set nusername="+words[2].toString()+"where nominee_id=last_insert_id()");
	        	 	break;
	        	 case 5: part='V';
	        	 ResultSet rset = stmt.executeQuery("select username from voters");
	        	 if(rset.getString(1)!=words[5].toString()){
	        		 int vote = Integer.parseInt(words[1]);
	        		 switch(vote){
	        		 case 0:vote=1;
	        		 ResultSet rset1 = stmt.executeQuery("select support from voters where username="+words[5].toString());
	        		 int support =rset1.getInt(0);
	        		 stmt.executeUpdate("insert into voters(id,username,support) values ("+words[2].toString()+","+words[5].toString()+","+(support+1)+")"); 
	        		 
	        		 ResultSet rset5 = stmt.executeQuery("select support from nominee where nominee_id=last_insert_id()");
	        		 int support1 =rset5.getInt(0);
	        		 stmt.executeUpdate("update nominee set support="+support1+"+1 where nominee_id=last_insert_id()");
	        		 	break;
	        		 case 1:vote=0;
	        		 ResultSet rset2 = stmt.executeQuery("select neutral from voters where username="+words[5].toString());
	        		 int neutral =rset2.getInt(0);
	        		 stmt.executeUpdate("insert into voters(id,username,neutral) values ("+words[2].toString()+","+words[5].toString()+","+(neutral+1)+")"); 
	        		 
	        		 ResultSet rset6 = stmt.executeQuery("select neutral from nominee where nominee_id=last_insert_id()");
	        		 int neutral1 =rset6.getInt(0);
	        		 stmt.executeUpdate("update nominee set neutral="+neutral1+"+1 where nominee_id=last_insert_id()");
	        		 	break;
	        		 case 2:vote=-1;
	        		 ResultSet rset3 =stmt.executeQuery("select opposed from voters where username="+words[5].toString());
	        		 int opposed =rset3.getInt(0);
	        		 stmt.executeUpdate("insert into voters(id,username,opposed) values ("+words[2].toString()+","+words[5].toString()+","+(opposed+1)+")"); 
	        		
	        		 ResultSet rset7 = stmt.executeQuery("select support from nominee where nominee_id=last_insert_id()");
	        		 int opposed1 =rset7.getInt(0);
	        		 stmt.executeUpdate("update nominee set opposed="+opposed1+"+1 where nominee_id=last_insert_id()");
	        		 	break;
	        		 }
	        	 }else{
	        		 int vote = Integer.parseInt(words[1]);
	        		 switch(vote){
	        		 case 0:vote=1;
	        		 ResultSet rset1 = stmt.executeQuery("select support from voters where username="+words[5].toString());
	        		 int support =rset1.getInt(0);
	        		 stmt.executeUpdate("update voters set support="+support+"+1 where username="+words[5].toString());
	        		 
	        		 ResultSet rset5 = stmt.executeQuery("select support from nominee where nominee_id=last_insert_id()");
	        		 int support1 =rset5.getInt(0);
	        		 stmt.executeUpdate("update nominee set support="+support1+"+1 where nominee_id=last_insert_id()");
	        		 	break;
	        		 case 1:vote=0;
	        		 ResultSet rset2 = stmt.executeQuery("select neutral from voters where username="+words[5].toString());
	        		 int neutral =rset2.getInt(0);
	        		 stmt.executeUpdate("update voters set neutral="+neutral+"+1 where username="+words[5].toString());
	        		 
	        		 ResultSet rset6 = stmt.executeQuery("select neutral from nominee where nominee_id=last_insert_id()");
	        		 int neutral1 =rset6.getInt(0);
	        		 stmt.executeUpdate("update nominee set neutral="+neutral1+"+1 where nominee_id=last_insert_id()");
	        		 	break;
	        		 case 2:vote=-1;
	        		 ResultSet rset3 = stmt.executeQuery("select opposed from voters where username="+words[5].toString());
	        		 int opposed =rset3.getInt(0);
	        		 stmt.executeUpdate("update voters set opposed="+opposed+"+1 where username="+words[5].toString());
	        		 
	        		 ResultSet rset7 = stmt.executeQuery("select opposed from nominee where nominee_id=last_insert_id()");
	        		 int opposed1 =rset7.getInt(0);
	        		 stmt.executeUpdate("update nominee set opposed="+opposed1+"+1 where nominee_id=last_insert_id()");
	        		 	break;
	        		 }
	        	 }
	        	 	break;
	        	 }
	        	 
	         }
	         scanner.close();
	       } catch (FileNotFoundException e) {
	         e.printStackTrace();
	       }
	    con.close();
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
