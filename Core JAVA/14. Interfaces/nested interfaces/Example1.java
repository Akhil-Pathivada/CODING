// An interface i.e. declared within another interface or class is known as nested interface.
//Example of nested interface which is declared within the interface....
interface Showable
{  
  void show();  
  interface Message
  {  
	void msg();  
  }  
}  
class TestNestedInterface1 implements Showable.Message
{  
	public void msg()
	{
		System.out.println("Hello nested interface");
	}   
}
class Example1
{
	public static void main(String args[])
	{  
		Showable.Message ob=new TestNestedInterface1();//upcasting here  
		ob.msg();  
	} 
}
/*
		Hello nested interface
*/