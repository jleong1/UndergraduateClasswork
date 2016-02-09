import java.sql.*;
import java.util.Scanner;
import java.io.*;

public class Elect {
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
		 Elect wiki = new Elect();
		 
		 wiki.insertData(con); //use only first time to insert existing data, already did it, don't need to do it again, if you do run it, takes a while (I know it's long time, wanted to change the structure, but couldn't figure out another way
		 String voter_username= readEntry("Enter voter username: ");
		 wiki.getVotes1(voter_username, con);
		 
		 String voter_id= readEntry("Enter voter id: ");
		 int voter = Integer.parseInt(voter_id);
		 wiki.getVotes(voter, con);
		 
		 String nominee_username= readEntry("Enter nominee username: ");
		 wiki.getVote3(nominee_username, con);
		 
		 String nominee_id= readEntry("Enter nominee id: ");
		 int nominee = Integer.parseInt(nominee_id);
		 wiki.getNominator(nominee, con);
		 
		 con.close();
		  }
	  
	  	//adds a new election with info
	  	//if I were to add a new election this would be the method I would use, 
	  /*
		public void addElection(Connection con)throws SQLException{
	  		Statement stmt = con.createStatement ();
	  		String [][] voters = null; //don't have any example data here, but this is a 2d array which holds voters and their info, also assume that each voter's array is same format as Wiki document
	  		Election race = new Election(1000,"cookieM",1021,"honeypot",voters); //example data,
	  		int id = race.getNomineeId();
	  		String nusername = race.getNominatorUsername();
	  		int nid = race.getNominatorId();
	  		String username = race.getNomineeUsername();
	  		stmt.executeUpdate("insert into nominee (username, nominee_id, nominator_id, nusername) values (\'"+username+"\',"+id+","+nid+",\'"+nusername+"\'");
	  		int nopposed =0; //votes for nominee
            int nsupport=0; // same as above
            int nneutral=0;// same as above
	  		for(int i=0;i<voters.length;i++){
	  			for(int j=0;j<voters.length;j++){
			        	 //query to check id
	  				if(j==1){
			        	 	int vote = Integer.parseInt(voters[i][j]);
			        	 	int userid = Integer.parseInt(voters[i][j+1]);
			        	 	int support = 0;
			        	 	int neutral = 0;
			        	 	int opposed = 0;
			        	 	ResultSet set = stmt.executeQuery("select voter_id from voter where username=\""+voters[i][j+4].toString()+"\"");
			        	 	if(!set.next()){
			        	 		if(vote==1){
			        	 			support=1;
			        	 			nsupport+=support;
			        	 			stmt.executeUpdate("update nominee set support="+nsupport+" where username=\""+username+"\"");
			        	 			stmt.executeUpdate("insert into voter(voter_id,username,support, opposed, neutral) values ("+id+",\""+voters[i][j+4].toString()+"\","+support+","+opposed+","+neutral+")");  
			        	 		}else if(vote==0){
			        	 			neutral=1;
			        	 			nneutral+=neutral;
			        	 			stmt.executeUpdate("update nominee set neutral="+nneutral+" where username=\""+username+"\"");
			        	 			stmt.executeUpdate("insert into voter(voter_id,username,neutral, support, opposed) values ("+id+",\""+voters[i][j+4].toString()+"\","+neutral+","+support+","+opposed+")");  
			        	 		}else{
			        	 			opposed =1;
			        	 			nopposed+=opposed;
			        	 			stmt.executeUpdate("update nominee set opposed="+nopposed+" where username=\""+username+"\"");
			        	 			stmt.executeUpdate("insert into voter(voter_id,username,opposed, support, neutral) values ("+id+",\""+voters[i][j+4].toString()+"\","+opposed+","+support+","+neutral+")"); 
			        	 		}
			        	 	}else{
			        	 		if(vote==1){
			        	 			ResultSet rset=stmt.executeQuery("select support from voter where username=\""+voters[i][j+4].toString()+"\"");
			        	 			support=1;
			        	 			if(!rset.next()){
			        	 				support=1;
			        	 			}else{
			        	 			support += rset.getInt(1);
			        	 			}
			        	 			nsupport=nsupport+1;
			        	 			stmt.executeUpdate("update nominee set support="+nsupport+" where username=\""+username+"\"");
			        	 			stmt.executeUpdate("update voter set support="+support+" where username=\""+voters[i][j+4].toString()+"\"");  
			        	 		}else if(vote==0){
			        	 			ResultSet rset=stmt.executeQuery("select neutral from voter where username=\""+voters[i][j+4].toString()+"\"");
			        	 			neutral=1;
			        	 			if(!rset.next()){
			        	 				neutral=1;
			        	 			}else{
			        	 			neutral += rset.getInt(1);
			        	 			}

			        	 			stmt.executeUpdate("update nominee set neutral="+nneutral+" where username=\""+username+"\"");
			        	 			stmt.executeUpdate("update voter set neutral="+neutral+" where username=\""+voters[i][j+4].toString()+"\"");  
			        	 		}else{
			        	 			ResultSet rset=stmt.executeQuery("select opposed from voter where username=\""+voters[i][j+4].toString()+"\"");
			        	 			opposed =1;
			        	 			if(!rset.next()){
			        	 				opposed=1;
			        	 			}else{
			        	 			opposed+= rset.getInt(1);
			        	 			}
			        	 	
			        	 			nopposed=nopposed+1;
			        	 			stmt.executeUpdate("update nominee set opposed="+nopposed+" where username=\""+username+"\"");
			        	 			stmt.executeUpdate("update voter set opposed="+opposed+" where username=\""+voters[i][j+4].toString()+"\""); 
			        	 		}
			        	 	}
			        	
			        	 }
			        	 
	  			}
	  		}
	  	
	  	  }*/
	  	  
	  //first time uploading data
	  
	  	  public void insertData(Connection con) throws SQLException{
			    Statement stmt = con.createStatement ();
			    String election = "";
		         int nopposed =0;
		         int nsupport=0;
		         int nneutral=0;
			    try {
			         File file = new File("C:/Users/Julie Leong/Documents/Wiki2.txt");
			         Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)));
			         int outcome=0;
			         while (scanner.hasNextLine()) {
			        	 String line = scanner.nextLine(); 
			        	 String[] words = line.split("\\s+");
			        	 String type = words[0].toString();
			        
			        	 switch(type){
			        	 case "#":
			        	 	break;
			        	 case "E":
			        	 	outcome = Integer.parseInt(words[1]);
			        	 	break;
			        	 case "T":
			        	 	break;
			        	 case "U":
			        	    nopposed =0;
				            nsupport=0;
				            nneutral=0;
				            int noid = Integer.parseInt(words[1]);
				            ResultSet nominees = stmt.executeQuery("select nominee_id from nominee where username=\""+words[2].toString()+"\"");
				            if(!nominees.next()){
			        	 	stmt.executeUpdate("insert into nominee (nominee_id, username,opposed,support,neutral) values (\"" + words[1].toString()+ "\", \""+words[2].toString()+"\", "+nopposed+", "+nsupport+", "+nneutral+")");
			        	 	stmt.executeUpdate("insert into election(nominee_id, username,outcome) values ("+noid+",\""+words[2].toString()+"\","+outcome+")");
				            }else{//does exist need to set values to what is currently in table
			        	 	ResultSet votes = stmt.executeQuery("select support, opposed, neutral from nominee where username=\""+words[2].toString()+"\"");
				            while(votes.next()){
				            	nsupport=votes.getInt(1);
				            	nopposed=votes.getInt(2);
				            	nneutral=votes.getInt(3);
				            	
				            }
				        	stmt.executeUpdate("insert into election(nominee_id, username,outcome) values ("+noid+",\""+words[2].toString()+"\","+outcome+")");
				            }
				            election=words[2].toString();
			        	 	break;
			        	 case "N":
			        		 int nid = Integer.parseInt(words[1]);
			        	 	stmt.executeUpdate("update nominee set nominator_id="+nid+" where username=\""+election+"\"");
			        	 	stmt.executeUpdate("update nominee set nusername=\""+words[2].toString()+"\" where username=\""+election+"\"");
			        	 	break;
			        	 case "V":
			        	 //query to check id
			        	 	int vote = Integer.parseInt(words[1]);
			        	 	int id = Integer.parseInt(words[2]);
			        	 	int support = 0;
			        	 	int neutral = 0;
			        	 	int opposed = 0;
			        	 	ResultSet set = stmt.executeQuery("select username from voter where voter_id="+id);
			        	 	if(!set.next()){
			        	 		if(vote==1){
			        	 			support=1;
			        	 			nsupport+=support;
			        	 			stmt.executeUpdate("update nominee set support="+nsupport+" where username=\""+election+"\"");
			        	 			stmt.executeUpdate("insert into voter(voter_id,username,support, opposed, neutral) values ("+id+",\""+words[words.length-1].toString()+"\","+support+","+opposed+","+neutral+")");  
			        	 		}else if(vote==0){
			        	 			neutral=1;
			        	 			nneutral+=neutral;
			        	 			stmt.executeUpdate("update nominee set neutral="+nneutral+" where username=\""+election+"\"");
			        	 			stmt.executeUpdate("insert into voter(voter_id,username,neutral, support, opposed) values ("+id+",\""+words[words.length-1].toString()+"\","+neutral+","+support+","+opposed+")");  
			        	 		}else{
			        	 			opposed =1;
			        	 			nopposed+=opposed;
			        	 			stmt.executeUpdate("update nominee set opposed="+nopposed+" where username=\""+election+"\"");
			        	 			stmt.executeUpdate("insert into voter(voter_id,username,opposed, support, neutral) values ("+id+",\""+words[words.length-1].toString()+"\","+opposed+","+support+","+neutral+")"); 
			        	 		}
			        	 	}else{
			        	 		if(vote==1){
			        	 			ResultSet rset=stmt.executeQuery("select support from voter where username=\""+words[words.length-1].toString()+"\"");
			        	 			support=1;
			        	 			if(!rset.next()){
			        	 				support=1;
			        	 			}else{
			        	 			support += rset.getInt(1);
			        	 			}
			        	 			nsupport=nsupport+1;
			        	 			stmt.executeUpdate("update nominee set support="+nsupport+" where username=\""+election+"\"");
			        	 			stmt.executeUpdate("update voter set support="+support+" where username=\""+words[words.length-1].toString()+"\"");  
			        	 		}else if(vote==0){
			        	 			ResultSet rset=stmt.executeQuery("select neutral from voter where username=\""+words[words.length-1].toString()+"\"");
			        	 			neutral=1;
			        	 			if(!rset.next()){
			        	 				neutral=1;
			        	 			}else{
			        	 			neutral += rset.getInt(1);
			        	 			}

			        	 			stmt.executeUpdate("update nominee set neutral="+nneutral+" where username=\""+election+"\"");
			        	 			stmt.executeUpdate("update voter set neutral="+neutral+" where username=\""+words[words.length-1].toString()+"\"");  
			        	 		}else{
			        	 			ResultSet rset=stmt.executeQuery("select opposed from voter where username=\""+words[words.length-1].toString()+"\"");
			        	 			opposed =1;
			        	 			if(!rset.next()){
			        	 				opposed=1;
			        	 			}else{
			        	 			opposed+= rset.getInt(1);
			        	 			}
			        	 	
			        	 			nopposed=nopposed+1;
			        	 			stmt.executeUpdate("update nominee set opposed="+nopposed+" where username=\""+election+"\"");
			        	 			stmt.executeUpdate("update voter set opposed="+opposed+" where username=\""+words[words.length-1].toString()+"\""); 
			        	 		}
			        	 	}
			        	 	break;
			        	 default:
			        	 	break;
			        	 }
			        	 
			         }
			         
			         scanner.close();
			       } catch (FileNotFoundException e) {
			         e.printStackTrace();
			       }
	  	  }
	  	  //get all collective votes of a voter by user id
	  	  public void getVotes(int id, Connection con) throws SQLException{
	  		Statement stmt = con.createStatement ();
			ResultSet rset = stmt.executeQuery("select username from voter where voter_id="+id+"");
	 		int support = 0;
	  		int neutral = 0;
	  		int opposed = 0;
	  		if(!rset.next()){
	  			System.out.println("Invalid voter username. Please try another");
	  		}else{
	  			ResultSet rset1 = stmt.executeQuery("select support from voter where voter_id="+id+"");
	  			while (rset1.next ()) {
	  				support = rset1.getInt(1);
	  				
	  			}
	  			ResultSet rset2 = stmt.executeQuery("select neutral from voter where voter_id="+id+"");
	  			while (rset2.next ()) {
	  				neutral = rset2.getInt(1);
	  				
	  			}
	  			ResultSet rset3 = stmt.executeQuery("select opposed from voter where voter_id="+id+"");
	  			while (rset3.next ()) {
	  				opposed = rset3.getInt(1);
	  				
	  			}
	  			
	  			System.out.println("User ID: "+id+" Support Votes: "+support+" Neutral Votes: "+neutral+" Opposed Votes: "+opposed);
	  		}
	  		
	  	  }
	  	  
	  	//get all collective votes of a voter by username
	  	  public void getVotes1(String username, Connection con) throws SQLException{
	  		Statement stmt = con.createStatement();
	  		ResultSet rset = stmt.executeQuery("select voter_id from voter where username='"+username+"'");
	 		int support = 0;
	  		int neutral = 0;
	  		int opposed = 0;
	  		if(!rset.next()){
	  			System.out.println("Invalid voter username. Please try another");
	  		}else{
	  			ResultSet rset1 = stmt.executeQuery("select support from voter where username='"+username+"'");
	  			while (rset1.next ()) {
	  				support = rset1.getInt(1);
	  				
	  			}
	  			ResultSet rset2 = stmt.executeQuery("select neutral from voter where username='"+username+"'");
	  			while (rset2.next ()) {
	  				neutral = rset2.getInt(1);
	  				
	  			}
	  			ResultSet rset3 = stmt.executeQuery("select opposed from voter where username='"+username+"'");
	  			while (rset3.next ()) {
	  				opposed = rset3.getInt(1);
	  				
	  			}
	  			
	  			System.out.println("Username: "+username+" Support Votes: "+support+" Neutral Votes: "+neutral+" Opposed Votes: "+opposed);
	  		}
	  		
	  	  }
	  	  
	  	//get all nominator username and id for a nominee by nominee user id
	  	 public void getNominator(int nominee_id, Connection con) throws SQLException{
	  		Statement stmt = con.createStatement();
	  		ResultSet rset = stmt.executeQuery("select nusername from nominee where nominee_id="+nominee_id);
	  		int nominator_id = 0;
	  		String nominator_username =""; 
	  		if(!rset.next()){
	  			System.out.println("Invalid nominee id. Either never nominated or does not exist. Please try another");
	  		}else{
	  			ResultSet rset1 = stmt.executeQuery("select nominator_id from nominee where nominee_id="+nominee_id);
	  			while (rset1.next ()) {
	  				nominator_id= rset1.getInt(1);
	  				
	  			}
	  			ResultSet rset2 = stmt.executeQuery("select nusername from nominee where nominee_id="+nominee_id);
	  			while (rset2.next ()) {
	  				nominator_username= rset2.getString(1);
	  				
	  			}
	  			System.out.println("Nominee ID: "+nominee_id+" Nominator ID: "+nominator_id+" Nominator username: "+nominator_username);
	  		}
	  	  }
	  	 
	  	//get all collective votes for a nominee by username
	  	 public void getVote3(String nusername, Connection con) throws SQLException{
	  		Statement stmt = con.createStatement();
	  		ResultSet rset = stmt.executeQuery("select nominee_id from nominee where username=\""+nusername+"\"");
	  		int support = 0;
	  		int neutral = 0;
	  		int opposed = 0;
	  		String outcome="";
	  		if(!rset.next()){
	  			System.out.println("Invalid nominee username. Please try another");
	  		}else{
		  		ResultSet rset1 = stmt.executeQuery("select support from nominee where username=\""+nusername+"\"");

	  			while (rset1.next ()) {
	  				support = rset1.getInt(1);
	  				
	  			}
		  		ResultSet rset2 = stmt.executeQuery("select neutral from nominee where username=\""+nusername+"\"");
		  		
	  			while (rset2.next ()) {
	  				neutral = rset2.getInt(1);
	  				
	  			}
	  			ResultSet rset3 = stmt.executeQuery("select opposed from nominee where username=\""+nusername+"\"");
	  			while (rset3.next ()) {
	  				opposed = rset3.getInt(1);
	  				
	  			}
	  			if(support>opposed){
	  				
	  				outcome="Won";
	  			}else{
	  				outcome="Lost";
	  			}
	  			System.out.println("Nominee username: "+nusername+" Support Votes: "+support+
	  					" Neutral Votes: "+neutral+" Opposed Votes: "+opposed+" Outcome: "+outcome);
	  		}
	  		  
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
