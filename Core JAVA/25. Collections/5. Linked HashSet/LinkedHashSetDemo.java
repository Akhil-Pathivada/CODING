
// LinkedHashSet maintains Insertion Order

import java.util.*;

class LinkedHashSetDemo
{
	public static void main(String args[])
	{
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		set.add("one");
		set.add("two");
		set.add("three");
		set.add("four");
		set.add("five");

		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext())
			System.out.print(itr.next() + " ");
	}
}

// one two three four five