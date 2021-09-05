// Example to Remove elememts from LinkedList

import java.util.*;

class LinkedListDemo4
{
	public static void main(String args[])
	{
		LinkedList<String> list1 = new LinkedList<String>();
		list1.add("akhil");
		list1.add("ravindra");
		list1.add("mahesh");
		System.out.println("Initial elements of LL : " + list1);

		//removing a specific element
		list1.remove("akhil");
		System.out.println("After invoking remove(object) method : " + list1);
		//removing a specific positioned element
		list1.remove(1);
		System.out.println("After invoking remove(index) method : " + list1);

		LinkedList<String>list2 = new LinkedList<String>();
		list2.add("prince");
		list2.add("raudra");
		list1.addAll(list2);
		System.out.println("After adding a new list : " + list1);

		list1.removeFirst();
		System.out.println("After removing the first element : "+list1);

		list1.removeLast();
		System.out.println("After removing the last element : "+list1);

		list1.add("prince");
		list1.add("raudra");
		System.out.println("After adding 2 more elements : "+list1);

		list1.removeFirstOccurrence("prince");
		System.out.println("After invoking the removeFirstOccurence() : " + list1);

		list1.removeLastOccurrence("raudra");
		System.out.println("After invoking the removeLastOccurence() : " + list1);
		//ll.clear();// clears the entire list
	}
}
/*
Initial elements of LL : [akhil, ravindra, mahesh]
After invoking remove(object) method : [ravindra, mahesh]
After invoking remove(index) method : [ravindra]
After adding a new list : [ravindra, prince, raudra]
After removing the first element : [prince, raudra]
After removing the last element : [prince]
After adding 2 more elements : [prince, prince, raudra]
After invoking the removeFirstOccurence() : [prince, raudra]
After invoking the removeLastOccurence() : [prince]
*/