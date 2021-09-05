
import java.util.*;

class ArrayDequeDemo1
{
	public static void main(String args[])
	{
		Deque<String> deque = new ArrayDeque<String>();
		deque.add("mahesh");
		deque.add("ravindra");
		deque.add("akhil");

		System.out.println("Initial Deque : " + deque);

		deque.offerFirst("raudra");
		
		System.out.println("After invoking offerFirst() : " + deque);
		
		deque.poll(); //same as pollFirst();
		
		System.out.println("After invoking poll() : " + deque);
		
		deque.pollLast();
		
		System.out.println("After invoking pollLast() : " + deque);
	}
}
/*
Initial Deque : [mahesh, ravindra, akhil]
After invoking offerFirst() : [raudra, mahesh, ravindra, akhil]
After invoking poll() : [mahesh, ravindra, akhil]
After invoking pollLast() : [mahesh, ravindra]
*/