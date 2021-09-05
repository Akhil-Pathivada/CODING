//Printing prime numbers between 1-100
class Primes_in_range
{
	public static void main(String args[])
	{
		int i=0,flag=1,j;
		for(i=2;i<=100;i++)
		{
			for(j=2;j<i;j++)
			{
				if(i%j==0)
				{
					flag=0;
					break;
				}
				else flag=1;
			}
			if(flag==1) System.out.println(" "+i);
		}
	}
}