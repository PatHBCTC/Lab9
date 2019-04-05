/*

*

* Lab 9 SQL Connection Test

*

*/

import java.sql.*;

public class Lab9SQLTest
{

   public static void main(String args[])
   {
   
      final String DatabaseURL = "sql1.cis.mc3.edu";
      
      try
      {
      // Create connection to SQL
      Connection conn = DriverManager.getConnection(DatabaseURL);
      System.out.println("Connected to: " + DatabaseURL);
      
      Statement stmt = conn.createStatement();
      
      String sqlStatement = "SELECT Student_FullName FROM Student";
      System.out.println("Statement created: " + stmt);
      
      ResultSet result = stmt.executeQuery(sqlStatement);
      
      while(result.next())
      {
      
         System.out.println(result.getString(""));
      
      }
      
      conn.close();
      
      }
      catch(Exception e)
      {
         
         System.out.println(e);
      
      }
   
   
   }

}
