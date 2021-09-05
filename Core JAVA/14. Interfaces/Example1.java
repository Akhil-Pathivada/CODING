//In this example, the Printable interface has only one method, and its implementation is provided in the A6 class.
interface printable
{  
	 int a = 10; //by default static and final
	 void print();  
}  
class A6 implements printable
{  
	public void print()
	{
		System.out.println("Hello");
	} 
}
class Example1
{
	public static void main(String args[])
	{  
		A6 ob= new A6();  
		ob.print();  
		System.out.println(" a : " + ob.a);
		System.out.println(" a : " + printable.a); // another way to access an interface member
	} 
}
/*
	Hello
	a : 10
	a : 10
*/