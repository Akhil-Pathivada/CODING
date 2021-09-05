//Java HashSet, Example ignoring duplicate elements

import java.util.*;
class HashSetDemo2
{
	public static void main(String args[])
	{
		HashSet<String> set=new HashSet<String>();
		set.add("mahesh");
		set.add("ravindra");
		set.add("akhil");
		set.add("mahesh");

		Iterator itr = set.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
	}
}
/*
mahesh
akhil
ravindra
*/