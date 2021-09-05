//A non-static class that is created inside a class but outside a method is called 'member inner class.'
class Outer
{
	private int x=10;
	void Msg()
	{
		Inner in2=new Inner();
		in2.Print();
	}
	class Inner
	{
		void Print()
		{
			System.out.println("Value of x :"+x);
		}
	}
}
class MemberDemo1
{
	public static void main(String args[])
	{
		Outer obj=new Outer();
		Outer.Inner in=obj.new Inner();
		in.Print();
		obj.Msg();
	}
}
/*
Value of x :10
Value of x :10
*/