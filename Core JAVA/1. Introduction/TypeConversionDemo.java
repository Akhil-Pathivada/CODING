class TypeConversionDemo
{
	public static void main(String args[])
	{
		int a='A';
		char b=66;
		//char c=234566;//lossy conversion
		//int d=false; //lossy conversion
		boolean e=1; // int can't be converted into boolean
		System.out.println(a);
		System.out.println(b);
		System.out.println();
	}
}