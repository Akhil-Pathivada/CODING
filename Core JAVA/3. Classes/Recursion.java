// A simple example of recursion (Factorial).
class Factorial
{
	int result;
	int Fact(int n)
	{
		if(n==1) return 1;
		else 
		{
			result=Fact(n-1)*n;
			return result;
		}
	}
}
class Recursion
{
	public static void main(String args[])
	{
		Factorial f=new Factorial();
		System.out.println("\n Factorial of 5 : "+f.Fact(5));
		System.out.println(" Factorial of 4 : "+f.Fact(4));
		System.out.println(" Factorial of 3 : "+f.Fact(3));
	}
}