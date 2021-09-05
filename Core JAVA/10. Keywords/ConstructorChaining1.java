// Constructor Chaining within same class using this() keyword :
// this() expression should always be the first statement in 'Constructor'
class ConstructorChaining1
{
	ConstructorChaining1() // constructor 1
	{
		this(5);
		System.out.println("this is default constructor....");
	}
	ConstructorChaining1(int x) // constructor 2
	{
		this(5,10);
		System.out.println("value of x : "+x);
	}
	ConstructorChaining1(int x,int y) //constructor 3
	{
		System.out.println("total value : "+(x+y));
	}
	public static void main(String args[])
	{
		ConstructorChaining1 ob=new ConstructorChaining1();
	}
}
/*
total value : 15
value of x : 5
this is default constructor....
*/