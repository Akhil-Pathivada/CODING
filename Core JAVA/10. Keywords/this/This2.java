// this: to invoke current class method
class A
{  
    void m()
	{
		System.out.println("hello m");
	}  
    void n()
	{  
		System.out.println("hello n");  
		this.m(); // same as m();
    }  
}  
class This2
{  
    public static void main(String args[])
	{  
		A a=new A();  
		a.n();  
    }
}  
/* output: 
	hello n
	hello m
*/