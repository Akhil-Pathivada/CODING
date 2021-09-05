/* 
We can't instantiate an Abstract class
(means) we can't create an object for Abstract class
*/

abstract class A
{
	abstract void method();
}

class B extends A
{
	int a;
}

class AbstractDemo
{
	public static void main(String args[])
	{
		A ob1, ob2;

		ob2 = new B();
		ob1 = new A();
	}
}
/* 
output :
			AbstractDemo.java:17: error: A is abstract; cannot be instantiated
                ob1=new A();


*/