//Java ArrayList example of isEmpty() method

import java.util.*;
class ArrayListDemo6
{
	public static void main(String args[])
	{
		ArrayList<String> al = new ArrayList<String>();
		System.out.println("ArrayList is empty : " + al.isEmpty());
		al.add("akhil");
		al.add("mahesh");
		al.add("ravindra");
		System.out.println(al);
		System.out.println("ArrayList is empty : " + al.isEmpty());
	}
}

/*
ArrayList is empty : true
[akhil, mahesh, ravindra]
ArrayList is empty : false
*/