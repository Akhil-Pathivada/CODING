class One
{
	int i=20;
	void Show()
	{
		System.out.println("Value in Super class i : "+i);
	}
}
class Two extends One
{
	int i=10;
	void Show()
	{
		System.out.println("Value in Sub class i : "+i);
		super.Show();
	}
}
class Super_key
{
	public static void main(String args[])
	{
		Two ob=new Two();
		ob.Show();
	}
}
/*
output : 

Value in Sub class i : 10
Value in Super class i : 20

*/