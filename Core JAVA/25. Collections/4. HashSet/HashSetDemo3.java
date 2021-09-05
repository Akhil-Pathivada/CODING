//Java HashSet example to remove elements

import java.util.*;

class HashSetDemo3
{
	public static void main(String args[])
	{
		HashSet<String> set = new HashSet<String>();
		set.add("mahesh");
		set.add("ravindra");
		set.add("akhil");
		System.out.println("Initial HashSet : " + set);
		
		HashSet<String> set2 = new HashSet<String>();
		set2.add("Robo");
		set2.add("Bombay");
		set.addAll(set2);

		System.out.println("After adding new elements : " + set);
		set.removeAll(set2);

		System.out.println("After removing new elements : " + set);
		set.removeIf(str->str.contains("akhil"));
		System.out.println("After invoking removeIf method ...." + set);
		//set.clear(); //clears the entire HashSet
	}
}
/*
Initial HashSet : [mahesh, akhil, ravindra]
After adding new elements : [mahesh, Bombay, akhil, Robo, ravindra]
After removing new elements : [mahesh, akhil, ravindra]
After invoking removeIf method ....[mahesh, ravindra]

*/