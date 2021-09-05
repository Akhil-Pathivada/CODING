// Example of Java Exception Handling where we using a try-catch statement to handle the exception.
class Example1
{
	public static void main(String args[])
	{
		try
		{
			int data = 100/0;
		}
		catch(ArithmeticException e)
		{
			System.out.println(e);
		}
		System.out.println("rest of the code....");
	}
}
/*
java.lang.ArithmeticException: / by zero

rest of the code....

*/