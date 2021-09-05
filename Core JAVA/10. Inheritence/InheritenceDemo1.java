class A
{
	int i,j;
	void Show1()
	{
		System.out.println("\n i : "+i+"\n j : "+j);
	}
}
class B extends A
{
	int k;
	void Show2()
	{
		System.out.println(" k : "+k);
	}
	void Sum()
	{
		System.out.println(" i+j+k = "+(i+j+k));
	}
}
class InheritenceDemo1
{
	public static void main(String args[])
	{
		A superOb=new A();
		B subOb=new B();
		superOb.i=10;
		superOb.j=20;
		System.out.println("\n Values of i,j,k for SuperOb : ");
		superOb.Show1();
		System.out.println("\n Values of i,j,k for SubOb : ");
		subOb.i=100;
		subOb.j=200;
		subOb.k=30;
		subOb.Show1();
		subOb.Show2();
		subOb.Sum();
	}
}
/* 
	Output : 
	
 Values of i,j,k for SuperOb :

 i : 10
 j : 20

 Values of i,j,k for SubOb :

 i : 100
 j : 200
 k : 30
 i+j+k = 330
			 */