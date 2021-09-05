//A static class i.e. created inside a class is called static nested class in java.
//It cannot access non-static data members and methods.
// static inner can only accessed by 'outer class name' only...
//It can access only static data members of outer class including private.
//Static nested class cannot access non-static (instance) data member or method.
class Outer
{
	static int data1=10;
	int data2=20; // gives compile error : if 'Inner' class access it
	private int data3=30;
	static class Inner
	{
		void msg()
		{
			System.out.println("Data1 : "+data1);
			//System.out.println("Data3 : "+data3); // compile error : static context can't access private
		}
		static void msg2()
		{
			System.out.println("Data1 : "+data1);
		}
		
	}
}
class StaticNestedDemo
{
	public static void main(String args[])
	{
		Outer.Inner obj=new Outer.Inner();
		obj.msg();
		obj.msg2();
		Outer.Inner.msg2();
	}
}
/*
Data1 : 10
Data1 : 10
Data1 : 10

*/