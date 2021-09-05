//Java HashSet from another Collection

import java.util.*;

class HashSetDemo4
{
	public static void main(String args[])
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("mahesh");
		list.add("ravindra");
		list.add("akhil");
		System.out.println("Initial List : " + list);

		HashSet<String> set = new HashSet<String>(list);
		System.out.println("Initial HashSet : " + set);

		set.add("prince");

		System.out.println("After adding to the Set: ");
		Iterator<String> itr = set.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
	}
}
/*
Initial List : [mahesh, ravindra, akhil]
Initial HashSet : [mahesh, akhil, ravindra]
After adding to the Set:
mahesh
akhil
ravindra
prince
*/