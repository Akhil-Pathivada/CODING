class Test
{
	int a,b;
	Test(int i,int j)
	{
		a=i;
		b=j;
	}
	void meth(Test ob)
	{
		a+=10;//  ob.a is same as 'a'
		b+=10;
	}
}
class PassObjReference
{
	public static void main(String args[])
	{
		Test obj=new Test(10,15);
		System.out.println("Before method called..."+obj.a+" "+obj.b);
		obj.meth(obj);
		System.out.println("After method called..."+obj.a+" "+obj.b);
	}
}
/*
Before method called...10 15
After method called...20 25
*/