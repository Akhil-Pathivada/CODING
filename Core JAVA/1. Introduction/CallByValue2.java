//In this example we are passing object as a value.
class CallByValue2
{
	int data=100;
	void Change(CallByValue2 ob)
	{
		ob.data=ob.data+100; //changes will be in local variable only
	}
	public static void main(String args[])
	{
		CallByValue2 ob=new CallByValue2();
		System.out.println("Before change: "+ob.data);
		ob.Change(ob);
		System.out.println("After change: "+ob.data);
	}
}
/*
Before change: 100
After change: 200
*/
