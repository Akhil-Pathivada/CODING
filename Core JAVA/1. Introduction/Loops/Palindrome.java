class Palindrome
{
	public static void main(String args[])
	{
		int num=12122,rev=0,temp;
		temp=num;
		System.out.println("\n Intial number : "+num);
		for(;num>0;rev=(rev*10)+(num%10),num/=10); 
			System.out.println("\n Reversed number : "+rev);
		if(rev==temp) System.out.println("\n Palindrome");
		else System.out.println("\n Not Palindrome");
		
	}
}