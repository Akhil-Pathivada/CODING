
//Java, finally example where exception doesn't occur.

class FinallyDemo
{
	public static void main(String args[])
	{
		try
		{
			int data = 25/5;
			System.out.println(data);
		}
		catch(NullPointerException e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("Finally block always executed");
		}
		System.out.println("rest of the code....");
	}
}
/*
5
Finally block always executed
rest of the code...
*/