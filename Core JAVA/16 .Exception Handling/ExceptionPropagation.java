
// 'Exception Propagation' means 'exception' thrown by a method will be caught in another method......

class ExceptionPropagation
{
	void M()
	{
		int data = 50/0;
	}
	void N()
	{
		M();
	}
	void P()
	{
			N();
	}
	public static void main(String args[])
	{
		ExceptionPropagation ob = new ExceptionPropagation();
		try
		{
			ob.P();
		}
		catch(Exception e)
		{
			System.out.println("Exception was found....."+e);
		}
		System.out.println("Exception handeled");
	}
}
/*
Exception was found.....java.lang.ArithmeticException: / by zero
Exception handeled
*/