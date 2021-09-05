// 'Method overloading' : changing no.of arguments passing
class Adder
{
	static int Add(int a,int b)
	{
		return a+b;
	}
	static int Add(int a,int b,int c) 
	{
		return a+b+c;
	}
}
class Method_overload
{
	public static void main(String args[])
	{
		System.out.println(Adder.Add(11,11));
		System.out.println(Adder.Add(11,11,11));
	}
}
/*
output:
	22
	33
*/