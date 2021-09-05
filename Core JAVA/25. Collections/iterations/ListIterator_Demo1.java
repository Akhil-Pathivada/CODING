/*
 Traversing list through List Iterator
 ListIterator can be 'bi-directional'
 traversing can be start from any position
*/

import java.util.*;

class ListIteratorDemo1
{
	public static void main(String args[])
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("mahesh");
		list.add("ravindra");
		list.add("akhil");
		
		System.out.println(list);
		
		ListIterator<String> itr = list.listIterator(); //prints from index-0 onwards
		while(itr.hasNext())
		{
			System.out.println(" Index-"+ itr.nextIndex() + " : " + itr.next());
		}
		
		ListIterator<String> itr2 = list.listIterator(1); // prints from index-1 onwards
		while(itr2.hasNext())
		{
			System.out.println(itr2.next());
		}
		
		ListIterator<String> itr3 = list.listIterator(list.size()); // prints in reverse order
		while(itr3.hasPrevious())
		{
			System.out.println(itr3.previous());
		}
	}
}
/*
[mahesh, ravindra, akhil]
 Index-0 : mahesh
 Index-1 : ravindra
 Index-2 : akhil
 
ravindra
akhil

akhil
ravindra
mahesh
*/