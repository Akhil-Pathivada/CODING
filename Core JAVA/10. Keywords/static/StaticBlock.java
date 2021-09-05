//Static block is executed before the main method at the time of classloading.
class StaticBlock
{
	static int a=3;
	static int b=10;
	static // static block
	{
		System.out.println(" Static block calls first.... ");
		b=a*4;
	}
	static void Show() //static method
	{
		System.out.println(" Static method called....");
		System.out.println("\n a: "+a);
		System.out.println("\n b: "+b);
	}
	public static void main(String args[])
	{
		System.out.println(" Main method called....");
		Show();
	}
	
}
/*
 Static block calls first....
 Main method called....
 Static method called....

 a: 3

 b: 12
 */