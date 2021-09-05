// Example of operations on LinkedList....

import java.util.*;
class LinkedListDemo3
{
	public static void main(String args[])
	{
		// creating an object to linked list
		LinkedList<String> LL = new LinkedList<String>();

		//adding elements to the linked list
		LL.add("A");
		LL.add("B");
		LL.addLast("C");
		LL.addFirst("D");
		LL.add(2,"E");
		LL.add("F");
		LL.add("G");

		System.out.println(" Linked List : " + LL);

		//removing elements from the linked list
		LL.remove("B");
		LL.remove(3); // deletes 'index 3 ' element
		LL.removeFirst();
		LL.removeLast();

		System.out.println(" Linked list after deletion : " + LL);

		boolean status =  LL.contains("E");
		if(status) 
			System.out.println(" LL contains E");
		else 
			System.out.println(" LL does not contains E ");

		// size of the Linked list
		int size = LL.size();
		System.out.println(" Size of LL : " + size);

		// get and set elements from the linked list
		Object element = LL.get(2);
		System.out.println(" Element returned by Get() : "+element);
		LL.set(2,"Z");
		System.out.println(" Final Linked List : "+LL);
	}
}
/*
 Linked List : [D, A, E, B, C, F, G]
 Linked list after deletion : [A, E, F]
 LL contains E
 Size of LL : 3
 Element returned by Get() : F
 Final Linked List : [A, E, Z]
 */