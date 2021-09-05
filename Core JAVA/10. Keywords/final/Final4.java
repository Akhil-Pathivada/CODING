// 'final' method can't be override...but can be inherited...
class A
{
	final void method()
	{
		System.out.println("Final method....");
	}
}
class Final4 extends A
{
	public static void main(String args[])
	{
		Final4 obj=new Final4();
		obj.method();
	}
}
/*
Final method....
*/