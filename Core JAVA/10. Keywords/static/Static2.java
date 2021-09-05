//Simple example....
class Demo
{
	int id;
	String name;
	static String ceo="larry page";
	Demo() // this is a 'constructor'
	{
		name="akhil pathivada";
		id=123;
		System.out.println("Constructor is called....");
	}
	void Show()
	{
		System.out.println("\n  " +id+" : "+name+ " : "+ceo );
	}
	/*static
	{
		System.out.println("\nStatic is called....");
		ceo="larry page";
	*/
}
class Static2
{
	public static void main(String args[])
	{
		Demo ob1=new Demo();
		Demo ob2=new Demo();
		ob1.Show();
		ob2.Show();
		System.out.println("\n CEO : "+Demo.ceo);
	}
}
/*
 123 : akhil pathivada : larry page

  123 : akhil pathivada : larry page

 CEO : larry page
 
 */