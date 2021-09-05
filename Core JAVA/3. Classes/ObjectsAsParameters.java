//  Objects can be passed as parameters into 'methods'
class Test
{
	int a,b;
	Test(int i,int j)
	{
		a=i;
		b=j;
	}
	boolean Equals(Test ob)
	{
		if(ob.a==a && ob.b==b) return true;
		else return false;
	}	
}
class ObjectsAsParameters
{
	public static void main(String args[])
	{
		Test ob1=new Test(10,20);
		Test ob2=new Test(10,20);
		Test ob3=new Test(11,25);
		Test  ob4=new Test(11,25);
		System.out.println("\n ob1==ob2 : "+ob1.Equals(ob2));
		System.out.println("\n ob1==ob2 : "+ob1.Equals(ob3));
		System.out.println("\n ob1==ob2 : "+ob3.Equals(ob1));
		System.out.println("\n ob1==ob2 : "+ob3.Equals(ob2));
		System.out.println("\n ob1==ob2 : "+ob4.Equals(ob3));
	}
}