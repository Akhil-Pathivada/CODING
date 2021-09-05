/*
 Map example : non-generic style
 Map doesn't allow duplicate keys...but allows duplicate values
*/

import java.util.*;

class MapExample1
{
	public static void main(String args[])
	{
		Map map = new HashMap();
		// adding elements to the map
		map.put(1,"ravindra");
		map.put(5,"mahesh");
		map.put(3,"akhil");
		map.put(4,"raudra");
		map.put(0,"prince");

		//traversing the Map
		Set set = map.entrySet(); //converting into set, so that we can traverse
		Iterator itr = set.iterator();
		
		while(itr.hasNext())
		{
			//Converting to Map.Entry so that we can get key and value separately  
			Map.Entry entry = (Map.Entry)itr.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
/*
0 prince
1 ravindra
3 akhil
4 raudra
5 mahesh
*/