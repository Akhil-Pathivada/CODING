//If you are overriding any method, overridden method (i.e. declared in subclass) must not be more restrictive

class A
{
	protected void Msg()
	{
		System.out.println("Hi...");
	}
}
class Def_Pro extends A
{
	void Msg()
	{
		System.out.println("Hi...");
	}
	public static void main(String args[])
	{
		Def_Pro obj=new Def_Pro();
		obj.Msg(); // compiler error
	}
}
//The default modifier is more restrictive than protected. That is why there is compile time error.