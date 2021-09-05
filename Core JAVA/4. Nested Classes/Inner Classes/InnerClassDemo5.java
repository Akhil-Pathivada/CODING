//we can’t have static method in a nested inner class 
//because an inner class is implicitly associated with an object of its outer class so it cannot define any static method for itself. 
class Outer
{
	void Show()
	{
		System.out.println("\n This is Outer class");
	}
	class Inner // run if we declare as 'static'
	{
		static void Display()
		{
			System.out.println("This is Inner class");
		}
	}
}
class InnerClassDemo5
{
	public static void main(String args[])
	{
		Outer.Inner in = new Outer().new Inner(); //Outer.Inner in = new Outer.Inner();
		in.Display();
	}
}
/*
Compile Time Error
*/