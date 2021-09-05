
//Java, finally example where exception  occurs and handeled

class FinallyDemo3
{
	public static void main(String args[])
	{
		try
		{
			int data = 25/0;
			System.out.println(data);
		}
		catch(ArithmeticException e)
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
java.lang.ArithmeticException: / by zero
Finally block always executed
rest of the code....
*/