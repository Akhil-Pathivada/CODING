// 'this' is used to distinguish local variable & instance variable
class Test
{
	int roll;
	String name;
	float fee;
	Test(int roll,String name,float fee)
	{
		this.roll=roll;
		this.name=name;
		this.fee=fee;
	}
	void Display()
	{
		System.out.println(roll+"  "+name+"  "+fee);
	}
}
class This
{
	public static void main(String args[])
	{
		Test ob1=new Test(1,"akhil",23f);
		Test ob2=new Test(2,"pathivada",43f);
		ob1.Display();
		ob2.Display();
	}
}
/*
1  akhil  23.0
2  pathivada  43.0
*/