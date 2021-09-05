//  Example for interface within the class
class A 
{
	interface NestedIF 
	{
		boolean isNotNegative(int x);
	}
}
class B implements A.NestedIF 
{
	public boolean isNotNegative(int x) 
	{
		return x < 0 ? false: true;
	}
}
class Example3 
{
	public static void main(String args[]) 
	{
		// use a nested interface reference
		A.NestedIF ob = new B();
		if(ob.isNotNegative(10))
			System.out.println("10 is not negative");
		if(ob.isNotNegative(-12))
			System.out.println("this won't be displayed");
	}
}
/*
   10 is not negative 
*/