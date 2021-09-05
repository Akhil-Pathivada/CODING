//this() : to invoke current class constructor
//Calling parametrized constructor from default constructor:
class A
{  
    A()
	{
		this(10); 
		System.out.println("inside default constructor");
	}  
    A(int x)
	{   
		System.out.println("inside parametrized constructor");  
    }  
}  
class This4
{  
    public static void main(String args[])
	{  
		A a=new A();  
    }
}  
/* 

inside parametrized constructor
inside default constructor

*/
