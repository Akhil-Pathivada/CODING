// An abstract class with constructor 
abstract class Base 
{ 
    Base() 
	{
		System.out.println("Base Constructor Called");
	} 
    abstract void fun(); 
} 
class Derived extends Base 
{ 
    Derived() 
	{
		//super();
		System.out.println("Derived Constructor Called"); 
	} 
    void fun()
	{
		System.out.println("Derived fun() called");
	} 
} 
class AbstractDemo3 
{ 
    public static void main(String args[]) 
	{  
       Derived d = new Derived(); 
    } 
} 
/*
Base Constructor Called
Derived Constructor Called

*/