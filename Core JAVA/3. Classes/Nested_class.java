class Outer
{
	int x=100;
	void Test()
	{
		System.out.println("\n Outer class called");
		Inner ob=new Inner();
		ob.Display();
	}
	class Inner
	{
		void Display()
		{
			System.out.println(" Inner class called");
			System.out.println("\n Value of x : "+x);
		}
	}
}
class Nested_class
{
	public static void main(String args[])
	{
		Outer ob1=new Outer();
		ob1.Test();
	}
}