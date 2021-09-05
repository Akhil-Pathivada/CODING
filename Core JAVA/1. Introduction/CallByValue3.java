class Test
{
	void meth(int i,int j)
	{
		i+=20;
		j+=20;
	}
}
class CallByValue3
{
	public static void main(String args[])
	{
		Test obj=new Test();
		int a=0,b=0;
		System.out.println("Before call : "+a+b);
		obj.meth(a,b);
		System.out.println("After call : "+a+b);
	}
}
/*
Before call : 00
After call : 00
*/