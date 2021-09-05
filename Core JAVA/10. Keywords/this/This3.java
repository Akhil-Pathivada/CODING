//this() : to invoke current class constructor
//Calling default constructor from parameterized constructor:
class A
{  
    A()
	{
		System.out.println("inside default constructor");
	}  
    A(int x)
	{  
		this();
		System.out.println("inside parametrized constructor");
		//System.out.println(x);  
    }  
}  
class This3
{  
    public static void main(String args[])
	{  
		A a=new A(10);  
    }
}  
/* 
	inside default constructor
	inside parametrized constructor

*/
