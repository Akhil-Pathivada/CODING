/*
  Example of 'retainAll()' method.....
  'retainAll()' is used to removing all the elements which are not matching with 'list' which is passed as argument....
*/
import java.util.*;

class ArrayListDemo5
{
	public static void main(String args[])
	{
		ArrayList<String> al = new ArrayList<String>();
		al.add("mahesh");
		al.add("ravindra");
		al.add("akhil");
		System.out.println(al);

		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("prince");
		al2.add("ravindra");
		System.out.println(al2);
		al.retainAll(al2);
		System.out.println(al);
	}
}

/*
[mahesh, ravindra, akhil]
[prince,ravindra]
[ravindra]
*/