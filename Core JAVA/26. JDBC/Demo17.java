
// Program to understand the 'Left Outer Join' and 'Right Outer Join'..... 

import java.sql.*;
import java.util.*;

class Demo17
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

			// using 'Left Outer Join' or simply 'Left Join'
			sql = "select emp.name, emp.age, actors.city from emp left join actors on emp.name=actors.name";

			rs = stmt.executeQuery(sql);

			while(rs.next())
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));

			// using 'Right Outer Join' or simply 'Right Join'
			sql = "select emp.name, emp.age, actors.city from emp right join actors on emp.name=actors.name";

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

sharukh 50 mumbai
mahesh 43 hyderabad
Vani Kapoor 37 kolkata
akhil 21 null
ravindra 38 null
Amir Khan null null
Katrina Kaif null null

mahesh 43 hyderabad
sharukh 50 mumbai
Vani Kapoor 37 kolkata
null null mumbai
null null chennai
*/