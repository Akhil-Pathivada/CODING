class CLA2
{
	public static void main(String args[])
	{
		System.out.println("\n CLA ");
		String s1=args[0];
		String s2=args[1];
		String s3=args[2];
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s1+s2+s3); // 100200300
		int a=Integer.parseInt(s1);
		int b=Integer.parseInt(s2);
		int c=Integer.parseInt(s3);
		System.out.println(a+b+c); // 600
	}
}
/*
input: 100 200 300
output : 600
*/