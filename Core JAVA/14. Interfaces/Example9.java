// Interface Inheritence
// A class implements an interface, but one interface can extends another interface.
interface Printable
{  
	int a = 10;
	void print();  
}  
interface Showable extends Printable
{  
	void show();  
}  
class TestInterface4 implements Showable
{  
	public void print()
	{
		System.out.println("Hello");
	}  
	public void show()
	{
		System.out.println("Welcome");
	}  
}
class Example9
{
	public static void main(String args[])
	{  
		Showable ob = new TestInterface4();  
		ob.print();  
		ob.show(); 
		System.out.println(" a : "+ob.a);
	}  
}
/*

Hello
Welcome
 a : 10

*/