//If you make any method as final, you cannot override it.
class Parent
{
	final void Run()
	{
		System.out.println("\n Super class called");
	}
}
class Final2 extends Parent
{
	void Run()
	{
		System.out.println("\n Sub class called");
	}
	public static void main(String args[])
	{
		Final2 ob=new Final2();
		ob.Run();
	}
}
/* 
	Compile Time Error :
		Final2.java:11: error: Run() in Final2 cannot override Run() in Parent
         void Run()
              ^
  overridden method is final
  */