
// Program for understanding the 'Aggregate Functions'....

import java.sql.*;
import java.util.*;

class Demo10
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

			// COUNT
			sql = "select count(name) from emp where gender='male'";

			rs = stmt.executeQuery(sql);

			while(rs.next())
				System.out.println(rs.getString(1));

			// SUM
			sql = "select sum(age) from emp where age<40 and gender='male'";

			rs = stmt.executeQuery(sql);

			while(rs.next())
				System.out.println(rs.getString(1));

			// AVERAGE
			sql = "select avg(age) from emp where gender='male'";

			rs = stmt.executeQuery(sql);

			while(rs.next())
				System.out.println(rs.getString(1));

			// MIN
			sql = "select min(age) from emp where gender='male'";

			rs = stmt.executeQuery(sql);

			while(rs.next())
				System.out.println(rs.getString(1));

			// MAX
			sql = "select max(age) from emp where gender='male'";

			rs = stmt.executeQuery(sql);

			while(rs.next())
				System.out.println(rs.getString(1));

			// FIRST 
			sql = "select id,name,age from emp limit 2"; // printing first 2 records

			rs = stmt.executeQuery(sql);

			while(rs.next())
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));

			// LAST
			sql = "select id,name,age from emp order by name desc  limit 2"; // printing last 2 records

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

4

59

38.0000

21

50

1 akhil 21
2 ravindra 38

5 Vani Kapoor 37
4 sharukh 50
*/