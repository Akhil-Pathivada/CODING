///static variables are shared among all the objects equally.....(common)
class Static
{
	int id;
	String name;
	static String ceo="Larry Page";
	public static void main(String args[])
	{
		Static ob1=new Static();
		Static ob2=new Static();
		ob1.id=1;
		ob1.name="akhil pathivada";
		ob2.id=2;
		ob2.name="mahesh babu";
		System.out.println(ob1.id+" : "+ob1.name+" : "+ob1.ceo);
		System.out.println(ob2.id+" : "+ob2.name+" : "+ob2.ceo);
	}
}
/*
1 : akhil pathivada : Larry Page
2 : mahesh babu : Larry Page
*/