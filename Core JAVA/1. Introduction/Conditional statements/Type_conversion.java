class Type_conversion
{
	public static void main(String args[])
	{
		int i=128;
		byte j;
		j=(byte)i; //Conversion of 'int' to 'byte'
		System.out.println("\n value of 128 in Byte : "+j);
		double a=128.123;
		int b;
		b=(int)a;
		System.out.println(" value of 128.123 in integer : "+b);
		b=(byte)a;
		System.out.println(" value of 128.123 in byte : "+b);
	}
}