
class ThrowDemo
{
	static void Validate(int age) 
	{
		if(age<18) 
		{
			//throw new ArithmeticException("not allowed to vote");
			throw new Exception("not allowed to vote"); // gives a Compile Time Error
		}
		else
			System.out.println("allowed to vote");
	}
	public static void main(String args[])
	{
		//try
		//{
		Validate(13);
		System.out.println("rest of the code....");
		//}
		//catch(ArithmeticException e){System.out.println(e);}
		//catch(Exception e){System.out.println(e);}
	}
}
/* Run Time Error
Exception in thread "main" java.lang.ArithmeticException: not allowed to vote
        at ThrowDemo.Validate(ThrowDemo.java:7)
        at ThrowDemo.main(ThrowDemo.java:14)
*/