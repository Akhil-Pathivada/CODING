
//LinkedHashSet ignores Duplicate elements

import java.util.*;

class LinkedHashSetDemo2
{
	public static void main(String args[])
	{
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		set.add("mahesh");
		set.add("ravindra");
		set.add("raudra");
		set.add("mahesh");
		set.add("raudra");

		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext())
			System.out.print(itr.next()+" ");
	}
}

// mahesh ravindra raudra