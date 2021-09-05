// A class created inside a method id called....'Local Inner Class'
//If you want to invoke the methods of local inner class, you must instantiate this class inside that enclosing method.
class LocalInnerDemo1
{
	private int a=20; // instance variable
	void show()
	{
		int b=20;//local variable must be final till jdk 1.7 only  
		class Inner
		{
			void print()
			{
				System.out.println("value of a,b :"+a+","+b);
			}
		}
		Inner in=new Inner();
		in.print();
	}
	public static void main(String args[])
	{
		LocalInnerDemo1 obj1=new LocalInnerDemo1();
		obj1.show();
		//in.print();//compile error
	}
}
//value of a,b :20,20