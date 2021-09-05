// instances of Inner class should only be defined in its Outer(enclosing) Class......
class Outer
{
	int outer_x=100;
	void Test()
	{
		//in.Display();
	}
	class Inner
	{
		void Display()
		{
			System.out.println("\n Outer_x = "+outer_x);
		}
	}
}
class InnerClassDemo2
{
	public static void main(String args[])
	{
		Outer out=new Outer();
		Inner in=new Inner();// compile error
		in.Display();
	}
}
/*
compile time error
*/