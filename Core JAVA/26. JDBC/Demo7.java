
// Program for understanding of the 'distinct' keyword....


import java.sql.*;
import java.util.*;

class Demo7
{
        public static void main(String args[])
        {
               try
               {
                    Class.forName("com.mysql.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root",""); 

                    System.out.println("Database Connection Success.....");

                    Statement stmt = con.createStatement();  
					
			             ResultSet rs = stmt.executeQuery("select distinct gender from emp");   

			              while(rs.next())  
					                System.out.println(rs.getString(1));  
					
			             con.close();	  
               } 
               catch(Exception e)
               {
               		System.out.println(e);
               }
        }
}

/*
Database Connection Success.....

male
female
*/