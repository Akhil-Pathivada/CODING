// 'Method overloading' : changing data types
class Adder
{
	static int Add(int a,int b)
	{
		return a+b;
	}
	static double Add(double a,double b) 
	{
		return a+b;
	}
}
class Method_overload2
{
	public static void main(String args[])
	{
		System.out.println(Adder.Add(11,11));
		System.out.println(Adder.Add(11.11,11.11));
	}
}
/*
output :
		22
		22.22
*/