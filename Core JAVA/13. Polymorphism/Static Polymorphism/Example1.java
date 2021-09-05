//Example for Dynamic Polymorphism
// Program where method of Super class is overriden by Sub class method 
class One
{
	void calculate(int x)
	{
		System.out.println("\n Sqaure value : "+(x*x));
	}
}
class Two extends One
{
	void calculate(int x)
	{
		System.out.println("\n Sqaure root : "+Math.sqrt(x));
	}
}
class Example1
{
	public static void main(String args[])
	{
		One ob=new Two();
		ob.calculate(25);
	}
}
/*
output :

		 Sqaure root : 5.0
*/