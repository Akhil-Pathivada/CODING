/*
 HashSet iterates in an unordered fashion
 because HashSet does not maintain any Insertion Order
*/

import java.util.*;

class HashSetDemo1
{
	public static void main(String args[])
	{
		HashSet<String> set = new HashSet<String>();
		set.add("one");
		set.add("two");
		set.add("three");
		set.add("four");
		set.add("five");
		Iterator itr = set.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
	}
}
/*
four
one
two
three
five
*/