import java.util.Scanner;
class ScanDemo3
{
	public static void main(String args[])
	{
		Scanner ob=new Scanner(System.in);
		int sum=0,count=0;
		for(int i=0;i<5;i++)
		{
			while(ob.hasNextInt())
			{
				int num=ob.nextInt();
				sum+=num;
				count++;
			}
		}
		int mean=sum/count;
		System.out.println("Mean : "+mean);
	}
}