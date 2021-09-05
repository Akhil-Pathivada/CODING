//The private access modifier is accessible only within class.
class A
{
	private int data=10;
	private void Msg()
	{
		System.out.println("Hi...Private method");
	}
}
class PrivateExample
{
	public static void main(String args[])
	{
		A obj=new A();
		obj.msg();// compile error
		System.out.println(obj.data); //compile error
	}
}