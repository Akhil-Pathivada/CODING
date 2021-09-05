// A class that has no name is called as 'Anonymous' class
// it should be used if we have to 'override' a method of interface/class
interface A
{
	void msg();
}
class AnonymousDemo 
{
	public static void main(String args[])
	{
		A obj=new A(){
			public void msg()
			{
				System.out.println("Hello...everyone");
			}
		};
		obj.msg();
	}
}
/*
Hello...everyone
*/