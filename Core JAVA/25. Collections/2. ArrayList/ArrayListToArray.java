//Obtaining an Array from an ArrayList
// converting an ArrayList to Array
import java.util.*;
class ArrayListToArray
{
	public static void main(String args[])
	{
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		System.out.println("Contents of ArrayList : " + al);
		Integer obj[] = new Integer[al.size()];
		obj = al.toArray(obj);
		System.out.print("Array1 : ");
		for(int i : obj)
			System.out.print(i + " ");
	}
}
/*
Contents of ArrayList : [1, 2, 3, 4]
Array1 : 1 2 3 4
*/
