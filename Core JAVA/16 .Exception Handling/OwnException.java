class MyException extends Exception
{
	int res;
	MyException(int a)
	{
		res=a;
	}
	public String toString()
	{
		return "MyException"+"["+res+"]";
	}
}
class OwnException
{
	static void meth(int x) throws MyException
	{
		System.out.println("entered into method...");
		if(x>10)
			throw new MyException(x);
		System.out.println("Normal flow.....");
	}
	public static void main(String args[])
	{
		try
		{
			meth(10);
			meth(20);
		}
		catch(MyException e){System.out.println("Caught : "+e);};
	}
}
/*
entered into method...
Normal flow.....
entered into method...
Caught : MyException[20]

*/