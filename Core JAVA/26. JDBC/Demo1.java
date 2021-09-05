
/*
Program for making connection with a existing database, 
and retrieving information from that table
*/

import java.sql.*;
import java.util.*;

class Demo1
{
        public static void main(String args[])
        {
               try
               {
                    Class.forName("com.mysql.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root",""); 

                    System.out.println("Database Connection Success.....");

                    Statement stmt = con.createStatement();  
					
			              ResultSet rs = stmt.executeQuery("select * from emp");   

			              while(rs.next())  
				              	System.out.println(rs.getInt(1)+"  "+rs.getString(2) + " " + rs.getString(3));  
					
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

1  akhil 21
2  ravindra 38
3  mahesh 43
*/