//traversing through a for loop
// random access is possible through 'Array List'
import java.util.*;
class ForLoop
{
	public static void main(String args[])
	{
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println("----------------");
		System.out.println(list);
		System.out.println("----------------");
		System.out.println(list.get(0)+list.get(1));
		System.out.println("----------------");
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
		System.out.println("----------------");
	}
}
/*
----------------
[1, 2, 3, 4, 5]
----------------
3
----------------
1
2
3
4
5
----------------
*/