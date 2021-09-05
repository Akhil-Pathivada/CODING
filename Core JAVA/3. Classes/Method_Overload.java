class Method_Overload
{
	void test()
	{
		System.out.println("\n no parameters");
	}
	void test(int a)
	{
		System.out.println(" one parameter : a="+a);
	}
	void test(int a,int b)
	{
		System.out.println(" two parameters : a="+a+" b ="+b);
	}
	double test(double a,double b)
	{
		return (a+b);
	}
	public static void main(String args[])
	{
		Method_Overload ob=new Method_Overload();
		ob.test();
		Method_Overload ob2=new Method_Overload();
		ob.test(10);
		Method_Overload ob3=new Method_Overload();
		ob.test(100,200);
		double result=ob.test(1.0,2.0);
		System.out.println(result);
	}
}