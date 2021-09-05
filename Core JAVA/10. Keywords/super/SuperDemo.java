// non-overriden method of 'super class' can be called only from a 'child class' method.....
class A 
{
	void method1()
	{
		System.out.println("inside method1...");
	}
}
class SuperDemo extends A
{	
	//method1(); //compile error
	void method2()
	{
		System.out.println("inside method2...");
		method1();
	}
	public static void main(String args[])
	{
		SuperDemo obj=new SuperDemo();
		obj.method2();
	}
}
/*
inside method2...
inside method1...
*/