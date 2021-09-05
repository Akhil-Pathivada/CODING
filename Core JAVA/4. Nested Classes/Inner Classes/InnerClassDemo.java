//Demonastrate an Inner class(non-static)
//nested classes which are not declared as 'static' are 'inner classes'
class Outer
{
	int outer_x=100;
	void Test()
	{
		Inner in=new Inner();
		in.Display();
	}
	class Inner // can be declared as 'private' also
	{
		void Display()
		{
			System.out.println("\n Outer_x = "+outer_x);
		}
	}
}
class InnerClassDemo
{
	public static void main(String args[])
	{
		Outer out=new Outer();
		out.Test();
	}
}
/*
Outer_x = 100
*/