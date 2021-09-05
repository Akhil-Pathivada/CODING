class Gcd
{
	public static void main(String args[])
	{
		int a=50,b=10,temp;
		for(temp=a%b;temp!=0;a=b,b=temp,temp=a%b);
		System.out.println("\n GCD : "+b);
	}
}