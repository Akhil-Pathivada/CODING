//static block and static variables are executed in order they are present in a program.
class StaticBlockVariables
{
	static int a= method1(); // calling a static method
	static 
	{
		System.out.println("Static block executed....");
	}
	static int method1()
	{
		System.out.println("static method executed....");
		return 20;
	}
	public static void main(String args[])
	{
		System.out.println("main method called....");
		System.out.println("value of a : "+a);
	}
}