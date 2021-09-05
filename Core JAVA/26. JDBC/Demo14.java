
// Program to understand the 'IS NULL' and 'IS NOT NULL' keyword...

import java.sql.*;
import java.util.*;

class Demo14
{
	public static void main(String args[]) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");

			System.out.println("Database Connection Success....");

			Statement stmt = con.createStatement();

			//stmt.execute("insert into emp(id,name,age,gender) values(6, 'Amir Khan', null, 'male'), (7,'Katrina Kaif', null, 'female')");

			ResultSet rs;

			String sql;

			// using 'IS NULL'
			sql = "select * from emp where age is null";

			rs = stmt.executeQuery(sql);

			while(rs.next())
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "+ rs.getString(4));

			// using 'IS NOT NULL'
			sql = "select * from emp where age is not null";

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

6 Amir Khan null male
7 Katrina Kaif null female

1 akhil 21 male
2 ravindra 38 male
3 mahesh 43 male
4 sharukh 50 male
5 Vani Kapoor 37 female

*/