
//Let's see an example to retrieve and remove the highest and lowest Value.

import java.util.*;

class TreeSetDemo3
{
	public static void main(String args[])
	{
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(55);
		set.add(43);
		set.add(12);
		set.add(99);

		System.out.println("Lowest value : " + set.pollFirst());
		System.out.println("Highest value : " + set.pollLast());
	}
}
/*
Lowest value : 12
Highest value : 99
*/