/*
comparison of AutoBoxed integer objects....
Integer x = 10 creates an object ‘x’ with value 10.
*/

class ComparisonDemo1
{
	public static void main(String args[])
	{
		Integer x=400;
		Integer y=400;

		if(x==y)
			System.out.println("Same");
		else
			System.out.println("Not Same");
	}
}
/*
Not Same

Since x and y refer to different objects, we get the output as “Not Same”
*/
