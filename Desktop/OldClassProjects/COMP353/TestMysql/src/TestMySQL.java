
/**
 * Write a description of class TestMySQL here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.sql.*;
import java.io.*;
public class TestMySQL
{
   
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
 String url = "jdbc:mysql://codd.cs.luc.edu/jleong1_123";

 //Get a connection to the database for a
 // user named root with a blank password.
 // This user is the default administrator
 // having full privileges to do anything.
 Connection con = DriverManager.getConnection(url,"jleong1", "p32872");
    Statement stmt = con.createStatement ();

    ResultSet rset = stmt.executeQuery
       
       ("select * from fare");
       
    while (rset.next ()) {
      System.out.println(
      rset.getString(1) + "  " +
                         rset.getString(2) + "  " +
                         rset.getString(3));
                         
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
