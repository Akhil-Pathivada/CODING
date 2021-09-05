
// Map example : Generic style(new)

import java.util.*;

class MapExample2
{
	public static void main(String args[])
	{
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(4,"mahesh");
		map.put(3,"ravindra");
		map.put(1,"prince");
		map.put(6,"akhil");

		// Traversing the map
		for(Map.Entry m : map.entrySet())
			System.out.println(m.getKey() + " " + m.getValue());
	}
}
/*
1 prince
3 ravindra
4 mahesh
6 akhil
*/