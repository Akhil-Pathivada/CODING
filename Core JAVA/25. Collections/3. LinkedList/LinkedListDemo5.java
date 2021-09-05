// Program for printing reverse of a LinkedList

import java.util.*;

class LinkedListDemo5
{
	public static void main(String args[])
	{
		LinkedList<String> ll = new LinkedList<String>();
		ll.add("akhil");
		ll.add("prince");
		ll.add("raudra");
		System.out.println("Initial List : " + ll);

		Iterator itr = ll.descendingIterator();
		System.out.print("Reverse order : ");

		while(itr.hasNext())
			System.out.print(itr.next()+"  ");
	}
}
/*
Initial List : [akhil, prince, raudra]
Reverse order : raudra  prince  akhil
*/