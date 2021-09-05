//Members of the inner class are known only within the scope of the
//inner class and may not be used by the outer class. For example,
// This program will not compile.
class Outer 
{
	int outer_x = 100;
	void test() 
	{
		Inner inner = new Inner();
		inner.display();
	}
	// this is an inner class
	class Inner 
	{
		int y = 10; // y is local to Inner
		void display() 
		{
			System.out.println("display: outer_x = " + outer_x);
		}
	}
	void showy()
	{
		System.out.println(y); // error, y not known here!
	}
}
class InnerClassDemo3
{
	public static void main(String args[]) 
	{
		Outer outer = new Outer();
		outer.test();
	}
}
/*
InnerClassDemo3.java:23: error: cannot find symbol
                System.out.println(y); // error, y not known here!
                                   ^
  symbol:   variable y
  location: class Outer
1 error


*/