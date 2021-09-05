// in JAVA , there is CallByValue but no CallByReference....
//In case of call by value original value is not changed
class CallByValue
{
	int data=100;
	void Change(int data)
	{
		data=data+100; //changes will be in local variable only
	}
	public static void main(String args[])
	{
		CallByValue ob=new CallByValue();
		System.out.println("Before change: "+ob.data);
		ob.Change(500);
		System.out.println("After change: "+ob.data);
	}
}
/*
Before change: 100
After change: 100
*/