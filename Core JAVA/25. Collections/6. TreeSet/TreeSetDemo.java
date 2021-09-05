/* 
  TreeSet maintains the objects in Ascending Order
 TreeSet only allows Unique values
*/

import java.util.*;

class TreeSetDemo
{
	public static void main(String args[])
	{
		TreeSet<String> set = new TreeSet<String>();
		set.add("mahesh");
		set.add("ravindra");
		set.add("raudra");
		set.add("ravindra");
		set.add("akhil");
		
		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext())
			System.out.println(itr.next());
	}
}
/*
akhil
mahesh
raudra
ravindra
*/
