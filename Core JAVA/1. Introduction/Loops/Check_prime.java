//Checking a number is Prime or not
class Check_prime
{
	public static void main(String args[])
	{
		int num=11;
		boolean isPrime=true;
		for(int i=2;i<num;i++)
		{
			if(num%i==0) 
			{
				isPrime=false;
				break;
			}
			else isPrime=true;
		}
		if(isPrime)  System.out.println("\n "+num+" is Prime number");
		else  System.out.println("\n "+num+" is not Prime number");
	}
}