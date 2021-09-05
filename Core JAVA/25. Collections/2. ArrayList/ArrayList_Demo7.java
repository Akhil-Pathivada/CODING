//Java ArrayList example of set() and get() method
import java.util.*;
class ArrayListDemo7
{
	public static void main(String args[])
	{
		ArrayList<String> al=new ArrayList<String>();
		al.add("akhil");
		al.add("mahesh");
		al.add("ravindra");
		System.out.println(al);
		System.out.println(al.get(1));
		//updating that index-1 element
		al.set(1,"super star"); 
		System.out.println(al);
		System.out.println(al.get(1));
	}
}
/*
[akhil, mahesh, ravindra]
mahesh
[akhil, super star, ravindra]
super star
*/
