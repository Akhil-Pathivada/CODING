// example to traverse the ArrayList elements using the for-each loop
import java.util.*;
class ForEach
{
	public static void main(String args[])
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("mahesh");
		list.add("ravindra");
		list.add("akhil");
		System.out.println(list);
		for(String obj:list)
			System.out.println(obj);
	}
}
/*
[mahesh, ravindra, akhil]
mahesh
ravindra
akhil
*/