// Primitive types are passed by value.
class Test
{
	void Math(int i,int j)
	{
		i*=2;
		j/=2;
	}
}
class CallByValue
{
	public static void main(String args[])
	{
		int a=2,b=2;
		System.out.println("\n Before calling :- a: "+a+" b : "+b);
		Test ob=new Test();
		ob.Math(a,b);
		System.out.println(" After calling :- a: "+a+" b : "+b);
	}
}
/* 
 Output : there are no changes in a,b values
 */