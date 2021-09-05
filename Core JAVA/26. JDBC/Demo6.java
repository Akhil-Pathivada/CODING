
// Program for Selecting the values of a particular record....

import java.sql.*;
import java.util.*;

class Demo6
{
        public static void main(String args[])
        {
               try
               {
                    Class.forName("com.mysql.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root",""); 

                    System.out.println("Database Connection Success.....");

                    Statement stmt = con.createStatement();  
					
			ResultSet rs = stmt.executeQuery("select name,gender from emp");   

			while(rs.next())  
				System.out.println(rs.getString(1) + " " + rs.getString(2)); 


			rs = stmt.executeQuery("select name,age from emp where id < 3");   

			while(rs.next())  
				System.out.println(rs.getString(1) + " " + rs.getString(2));
					
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
akhil male
ravindra male
mahesh male
sharukh male
Vani Kapoor female


akhil 21
ravindra 38
*/