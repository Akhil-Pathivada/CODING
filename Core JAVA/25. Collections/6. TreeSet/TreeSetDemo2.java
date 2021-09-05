
//Let's see an example of traversing elements in descending order.

import java.util.*;

class TreeSetDemo2
{
	public static void main(String args[])
	{
		TreeSet<String> set = new TreeSet<String>();
		set.add("mahesh");
		set.add("ravindra");
		set.add("raudra");
		set.add("ravindra");
		set.add("akhil");

		Iterator<String> itr = set.descendingIterator();
		
		while(itr.hasNext())
			System.out.println(itr.next());
	}
}

/*
ravindra
raudra
mahesh
akhil
*/