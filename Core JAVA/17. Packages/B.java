//Example of package that import the packagename.*

package pack2;

import pack.*;

class B
{
	public static void main(String args[])
	{
		A obj = new A();
		obj.Msg();
	}
}
// java pack2.B