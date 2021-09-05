/*
 Example of Array and ArrayList......
 Array : static 
 ArrayList : dynamic
*/

import java.util.*;

class ArrayDemo
{
	public static void main(String args[])
	{
		int arr[] = new int[2];
		arr[0] = 123;
		arr[1] = 456;

		// Run time Error
		//arr[2]=789; 
		System.out.println("Array : " + arr);
		System.out.println("Array element : " + arr[0]);

		ArrayList<Integer> al = new ArrayList<Integer>(2);
		al.add(123);
		al.add(456);
		al.add(789);
		System.out.println("ArrayList : " + al);
		System.out.println("ArrayList element : " + al.get(2));
		System.out.println(Arrays.toString(arr));
	}
}

/*
Array : [I@1f32e575
Array element : 123
ArrayList : [123, 456, 789]
ArrayList element : 789
[123, 456]
*/