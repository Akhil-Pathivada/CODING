// An abstract class with a final method && static method..
abstract class Base 
{ 
    final void fun() 
	{
		System.out.println("This is final method"); 
	} 
	static void fun2()
	{
		System.out.println("This is static method");
	}
	/*default void fun3() // not allowed
	{
		System.out.println("This is default method");
	}*/
}   
class Derived extends Base 
{
	
} 
   
class AbstractDemo5
{ 
    public static void main(String args[]) 
	{  
		Derived b = new Derived(); 
		b.fun(); 
		Base.fun2();
		//Base.fun3(); // compile error
		//Base.fun();// compile error
    } 
}  
/*
This is final method
This is static method
*/