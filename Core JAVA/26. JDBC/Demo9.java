
// Program for understanding the 'Group By' keyword....


import java.sql.*;
import java.util.*;

class Demo9
{
        public static void main(String args[])
        {
               try
               {
                    Class.forName("com.mysql.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root",""); 

                    System.out.println("Database Connection Success.....");

                    Statement stmt = con.createStatement();  
			  
                    // COUNT
			  ResultSet rs = stmt.executeQuery("select gender,count(*)from emp group by gender");

			   while(rs.next())  
				 System.out.println(rs.getString(1) +" " + rs.getString(2) );  

			   // SUM
			   rs = stmt.executeQuery("select gender,sum(age)from emp group by gender");

			   while(rs.next())  
				 System.out.println(rs.getString(1) +" " + rs.getString(2));

			   // MIN  
			   rs = stmt.executeQuery("select name,max(age)from emp group by name");

			   while(rs.next())  
				 System.out.println(rs.getString(1) +" " + rs.getString(2));

			   
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

female 1
male 4

female 37
male 152

akhil 21
ravindra 38
mahesh 43
sharukh 50
Vani Kapoor 37
*/