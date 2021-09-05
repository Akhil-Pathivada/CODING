abstract class A
{
	abstract void msg();
}
class AnonymousDemo2
{
	public static void main(String args[])
	{
		A obj=new A(){
			public void msg()
			{
				System.out.println("Hello....everyone");
			}
		};
		obj.msg();
	}
}
/*
Hello....everyone
*/