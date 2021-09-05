// this : used to return the current class instance....
class This8
{
	int a;
	int b;
	This8()
	{
		a=20;
		b=30;
	}
	This8 Get()
	{
		return this;
	}
	void Display()
	{
		System.out.println("\n a : "+a+" b : "+b);
	}
	public static void main(String args[])
	{
		This8 obj=new This8();
		obj.Get().Display();
	}
}