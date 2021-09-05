
// Program for printing schema of the table

import java.sql.*;
import java.util.*;

class Demo3
{
        public static void main(String args[])
        {
               try
               {
                    Class.forName("com.mysql.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root",""); 

                    System.out.println("Database Connection Success.....");

                    Statement stmt = con.createStatement();  
					
                    ResultSet resultSet = stmt.executeQuery("SELECT * FROM emp");
                 
                    ResultSetMetaData metaData = resultSet.getMetaData();
                  
                    System.out.println("Number of columns: "+metaData.getColumnCount());
                  
                    System.out.println("Table description...!");
    
                    for(int i=1;i <= metaData.getColumnCount();i++)
                          System.out.println(metaData.getColumnName(i)+"\t"+metaData.getColumnTypeName(i));

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
Number of columns: 4
Table description...!
id  INT
name  VARCHAR
age INT
gender  VARCHAR
*/
