//Static Polymorphism using 'static'
// Program to use Super class reference to call Super class method 
// 'dynamic method dispatch' will not be work ,if we declare the overriden method as 'static'
class One
{
	static void calculate(int x)//static declaration
	{
		System.out.println("\n Sqaure value : "+(x*x));
	}
}
class Two extends One
{
	static void calculate(int x) //gives 'compile error' , if we doesn't declare as 'static'
	{
		System.out.println("\n Sqaure root : "+Math.sqrt(x));
	}
}
class Example2
{
	public static void main(String args[])
	{
		One ob=new Two();
		ob.calculate(25);
	}
}
/*
output :

		  Sqaure value : 625
*/