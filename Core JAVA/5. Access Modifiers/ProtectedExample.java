//The protected access modifier is accessible within package and outside the package but through inheritance only.
import pack.*;
class ProtectedExample extends pack.A
{
	public static void main(String args[])
	{
		ProtectedExample obj=new ProtectedExample();
		obj.Msg();
	}
}