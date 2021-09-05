
//Java, finally example where exception  occurs and not handeled

class FinallyDemo2
{
	public static void main(String args[])
	{
		try
		{
			int data = 25/0;
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
Finally block always executed
Exception in thread "main" java.lang.ArithmeticException: / by zero
        at FinallyDemo2.main(FinallyDemo2.java:8)
*/