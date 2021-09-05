class Decimal_binary
{
	static int Convert(int num)
	{
		if(num==0) 
			return 0;
		else 
			return num%2+10*Convert(num/2);
	}
	public static void main(String args[])
	{
		int num=8;
		System.out.println("\n The Binary number : "+Convert(num));
	}
}