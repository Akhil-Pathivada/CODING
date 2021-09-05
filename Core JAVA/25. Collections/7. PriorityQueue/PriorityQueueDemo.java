
//The PriorityQueue class provides the facility of using queue.

import java.util.*;

class PriorityQueueDemo
{
	public static void main(String args[])
	{
		PriorityQueue<String> q = new PriorityQueue<String>();
		q.add("one");
		q.add("two");
		q.add("three");
		q.add("four");
		q.add("five");

		System.out.println("Initial Queue : " + q);
		System.out.println("Head : " + q.element());
		System.out.println("Peek : " + q.peek());
		System.out.println("Queue elements are : ");
		
		Iterator<String> itr = q.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
		q.remove(); //removing the 'head'
		System.out.println("After invoking remove() : " + q);
		
		q.poll(); //removing 'head' and 'reversing' the queue
		System.out.println("After invoking poll() : " + q);
	}
}
/*
Initial Queue : [five, four, three, two, one]
Head : five
Peek : five
Queue elements are : 
five
four
three
two
one
After invoking remove() : [four, one, three, two]
After invoking poll() : [one, two, three]
*/