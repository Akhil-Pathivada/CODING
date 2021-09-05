//If you make any class as final, you cannot extend it.
final class Parent
{
	void Run()
	{
		System.out.println("\n Super class called");
	}
}
class Final3 extends Parent
{
	void Run()
	{
		System.out.println("\n Sub class called");
	}
	public static void main(String args[])
	{
		Final2 ob=new Final2();
		ob.Run();
	}
}
/*
		Compile Time Error


*/	