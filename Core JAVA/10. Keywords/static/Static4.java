// static block example....
class Demo
{
	static int a=5;
	static int b=10;
	static //static block
	{
		System.out.println("\n Akhil pathivada calls first ");
	}
	static void Callme()
	{
		System.out.println("\n a : "+a);
	}
}
class Static4
{
	public static void main(String args[])
	{
		Demo.Callme();
		System.out.println("\n b : "+Demo.b);
	}
}
/*

 Akhil pathivada calls first


 a : 5

 b : 10
 
 */