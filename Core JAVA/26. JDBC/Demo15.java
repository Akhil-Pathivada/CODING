
// Program to understand the 'IS NULL' and 'IS NOT NULL' keyword...

import java.sql.*;
import java.util.*;

class Demo15
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

			// using 'BETWEEN'
			sql = "select * from emp where age between 20 and 40";

			rs = stmt.executeQuery(sql);

			while(rs.next())
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "+ rs.getString(4));

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

1 akhil 21 male
2 ravindra 38 male
5 Vani Kapoor 37 female
*/