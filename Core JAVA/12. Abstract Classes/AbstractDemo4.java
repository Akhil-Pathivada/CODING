// An abstract class without any abstract method 
abstract class Base 
{
		Base()
		{
			System.out.println("\n Abstract Constructor called \n");
		}
		void fun() 
		{
			System.out.println("Base fun() called"); 
		} 
} 
   
class Derived extends Base 
{
	
} 
   
class AbstractDemo4 
{ 
    public static void main(String args[])
	{  
        Derived d = new Derived(); 
        d.fun(); 
    } 
}
/*
 Abstract Constructor called

Base fun() called
*/