// Creating & displaying a Single Linked List

import java.util.*;

public class LinkedListDemo
{
	public static void main(String args[])
	{
		LinkedList<String> LL = new LinkedList<String>();
		LL.add("mahesh");
		LL.add("ravindra");
		LL.add("akhil");

		System.out.println(LL);

		Iterator<String> itr = LL.iterator();
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