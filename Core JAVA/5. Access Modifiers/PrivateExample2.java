//If you make any class constructor private, you cannot create the instance of that class from outside the class.
class A
{
	private A()
	{}
	
}
class PrivateExample2
{
	public static void main(String args[])
	{
		A obj=new A(); //compile error
	}
}
/*
Note: A class cannot be private or protected except nested class.
*/