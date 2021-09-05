// java program to demonstrate restriction on static methods 
class Restrictions
{
	static int a=20;
	int b=30;
	static void method1()
	{
		System.out.println("inside method1...");
		method2(); //compile error
		System.out.println("value of a : "+a);
		System.out.println("value of a : "+b); //compile error
	}
	void method2()
	{
		System.out.println("inside method2...");
	}
	public static void main(String args[])
	{
		Restrictions.method1();
	}
}
/*
Restrictions.java:9: error: non-static method method2() cannot be referenced from a static context
                method2();
                ^
Restrictions.java:11: error: non-static variable b cannot be referenced from a static context
                System.out.println("value of a : "+b);
*/