
// Adding new records into the table...

import java.sql.*;
import java.util.*;

class Demo4
{
        public static void main(String args[])
        {
               try
               {
                    Class.forName("com.mysql.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root",""); 

                    System.out.println("Database Connection Success.....");

                    Statement stmt = con.createStatement();

			  stmt.execute("insert into emp(id,name,age,gender) values (4, 'sharukh', 50,'male'), (5, 'Vani Kapoor', 37, 'female')");	

			  // stmt.execute("delete from emp where id = 4");	
			  
			  ResultSet rs = stmt.executeQuery("select * from emp");   

			  while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2) + " " + rs.getString(3) + rs.getString(4));  
					
			  con.close();	  
               } 
               catch(Exception e)
               {
               		System.out.println(e);
               }
        }
}

/*
1  akhil 21
2  ravindra 38
3  mahesh 43
4  sharukh 50  male
5  Vani Kapoor 37  female
*/