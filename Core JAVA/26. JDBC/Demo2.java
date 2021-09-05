
// Program for addding new colomn 'gender' into the table

import java.sql.*;
import java.util.*;

class Demo2
{
        public static void main(String args[])
        {
               try
               {
                    Class.forName("com.mysql.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root",""); 

                    System.out.println("Database Connection Success.....");

                    Statement stmt = con.createStatement();  
					
                   stmt.execute("alter table emp add gender varchar(6) not null");

                    System.out.println("Successfully added 'gender' column....");

                   // stmt.execute("alter table emp drop column gender"); 
                    
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
Successfully added 'gender' column....
*/