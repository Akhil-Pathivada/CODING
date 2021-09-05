
// Program to understand the 'IN' keyword...

import java.sql.*;
import java.util.*;

class Demo12
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

			// using 'OR' 
			sql = "select * from emp where name = 'akhil' or name = 'ravindra' or name = 'mahesh'";

			rs = stmt.executeQuery(sql);

			while(rs.next())
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "+ rs.getString(4));

			// using 'IN'
			sql = "select * from emp where name in ('akhil','ravindra','mahesh')";

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
3 mahesh 43 male

1 akhil 21 male
2 ravindra 38 male
3 mahesh 43 male
*/