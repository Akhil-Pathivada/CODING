// Objects are passed by reference.
class Test
{
	int a,b;
	Test(int i,int j)
	{
		a=i;
		b=j;
	}
	void Math(Test ob)
	{
		ob.a*=2;
		ob.b/=2;
	}
}
class CallByReference
{
	public static void main(String args[])
	{
		Test ob1=new Test(2,2);
		System.out.println("\n Before calling : a= "+ob1.a+" b= "+ob1.b);
		ob1.Math(ob1);
		System.out.println(" After calling : a= "+ob1.a+" b= "+ob1.b);
	}
}
/* 
 Output : there are changes in a,b values
 */