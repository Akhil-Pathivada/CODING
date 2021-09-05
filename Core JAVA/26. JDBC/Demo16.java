
// Program to understand the 'INNER JOIN' 

import java.sql.*;
import java.util.*;

class Demo16
{
	public static void main(String args[]) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");

			System.out.println("Database Connection Success....");

			Statement stmt = con.createStatement();

			ResultSet rs;

			String sql;

			// using 'INNER JOIN' or simply 'JOIN'
			sql = "select emp.name, emp.age, actors.city from emp join actors on emp.name=actors.name";

			rs = stmt.executeQuery(sql);

			while(rs.next())
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));

			con.close();	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

/*
Database Connection Success....

mahesh 43 hyderabad
sharukh 50 mumbai
Vani Kapoor 37 kolkata
*/