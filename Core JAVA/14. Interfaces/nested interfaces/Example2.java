// Example of nested interface which is declared within the class
class A
{  
  interface Message
  {  
    void msg();  
  }  
}
class TestNestedInterface2 implements A.Message
{  
	public void msg()
	{
		System.out.println("Hello nested interface");
	}   
}
class Example2
{ 
	public static void main(String args[])
	{  
		A.Message ob=new TestNestedInterface2();//upcasting here  
		ob.msg();  
	} 
}
/*
	Hello nested interface
*/