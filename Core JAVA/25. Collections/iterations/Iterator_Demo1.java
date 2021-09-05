/*
 Example to traverse ArrayList elements using the Iterator interface.
 iterator interface can be only move in 'forward' direction....
*/

import java.util.*;

class IteratorDemo1
{
	public static void main(String args[])
	{
		ArrayList<String> list = new ArrayList<String>();

		list.add("mahesh");
		list.add("ravindra");
		list.add("akhil");

		System.out.println(list);

		Iterator itr = list.iterator();

		while(itr.hasNext())
			System.out.println(itr.next());
	}
	
}

/*
[mahesh, ravindra, akhil]
mahesh
ravindra
akhil
*/