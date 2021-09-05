class Pyramid
{
	public static void main(String args[])
	{
		for(int i=0;i<=5;i++) // 'i' indicates no.of rows
		{
			for(int sp=0;sp<=5-i;sp++) // 'sp' indicates no.of spaces
			{
				System.out.print(" ");
			}
			for(int j=0;j<i;j++) // 'j' indicates no.of colomns
			{
				System.out.print(" * ");
			}
			System.out.println();
		}
	}
}