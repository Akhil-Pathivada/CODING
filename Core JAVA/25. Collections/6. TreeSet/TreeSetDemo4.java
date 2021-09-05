
//In this example, we perform various NavigableSet operations.

import java.util.*;

class TreeSetDemo4
{
	public static void main(String args[])
	{
		TreeSet<String> set = new TreeSet<String>();
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");
		set.add("E");

		System.out.println("Initial Set : " + set);
		System.out.println("Reverse Order : " + set.descendingSet());
		System.out.println("HeadSet : " + set.headSet("C",true));
		System.out.println("TailSet : " + set.tailSet("C",false));
		System.out.println("Subset : " + set.subSet("A",false,"D",true));// by default(@,true,@,false)
	}
}
/*
Initial Set : [A, B, C, D, E]
Reverse Order : [E, D, C, B, A]
HeadSet : [A, B, C]
TailSet : [D, E]
Subset : [B, C, D]
*/