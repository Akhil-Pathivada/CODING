// returning objects from methods
class Test
{
	int a;
	Test(int i)
	{
		a=i;
	}
	Test incByTen()
	{
		Test temp=new Test(a+10);
		return temp;
	}
}
class Return_objects
{
	public static void main(String args[])
	{
		Test ob1=new Test(2);
		Test ob2;
		ob2=ob1.incByTen();
		System.out.println(" intial :: ob1.a = "+ob1.a);
		System.out.println(" after first increment :: ob2.a = "+ob2.a);
		ob2=ob2.incByTen();
		System.out.println(" after second increment :: ob2.a = "+ob2.a);
		ob2=ob2.incByTen();
			System.out.println(" after third increment :: ob2.a = "+ob2.a);
	}
}