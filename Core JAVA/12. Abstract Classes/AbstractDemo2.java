abstract class A
{
	abstract void callme();
	 void callmetoo()
	{
			System.out.println("\n This is a Concrete method ");
	}
}
class B extends A
{
	void callme()
	{
		System.out.println(" B 's implentation of callme");
	}
	
}
class AbstractDemo2
{
	public static void main(String args[])
	{
		B ob = new B();
		
		ob.callme();
		ob.callmetoo();
	}
}
/*
output : 
		B 's implentation of callme

		This is a Concrete method


*/