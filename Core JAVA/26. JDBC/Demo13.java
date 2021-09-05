
// Program to understand the 'NOT' keyword...

import java.sql.*;
import java.util.*;

class Demo13
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

			// using 'NOT'
			sql = "select * from emp where name not in ('akhil','ravindra','mahesh')";

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

4 sharukh 50 male
5 Vani Kapoor 37 female
*/