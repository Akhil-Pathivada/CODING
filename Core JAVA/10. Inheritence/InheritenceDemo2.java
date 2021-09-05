// subclass can't access the 'private' members of the Super class
class A
{
	int i;
	private int j;
	void Set(int x,int y)
	{
		i=x;
		j=y;
	}
}
class B extends A
{
	void Sum()
	{
		System.out.println(" i+j = "+(i+j));
	}
}
class InheritenceDemo
{
	public static void main(String args[])
	{
		A superOb=new A();
		B subOb=new B();
		subOb.Set(10,20);
		subOb.Sum(); // Compile Time Error
	}
}
/* 
	error: j has private access in A
                System.out.println(" i+j = "+(i+j));
*/