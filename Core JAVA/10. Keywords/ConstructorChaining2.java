//order in constructor chaining is not important.
class ConstructorChaining2
{
	ConstructorChaining2() // constructor 1
	{
		System.out.println("this is default constructor....");
	}
	ConstructorChaining2(int x) // constructor 2
	{
		this();
		System.out.println("value of x : "+x);
	}
	ConstructorChaining2(int x,int y) //constructor 3
	{
		this(x);
		System.out.println("total value : "+(x+y));
	}
	public static void main(String args[])
	{
		ConstructorChaining2 ob=new ConstructorChaining2(5,10);
	}
}
/*
this is default constructor....
value of x : 5
total value : 15
*/