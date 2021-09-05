import java.util.Scanner;
class ScanDemo2
{
	public static void main(String args[])
	{
		Scanner ob=new Scanner(System.in);
		System.out.println("\n Enter the string :");
		String s1=ob.nextLine(); // examine with 'next'
		System.out.println(s1);
		System.out.println("\n Enter the string :");
		String s2=ob.next();
		System.out.println(s2);
		System.out.println(" Program ends ");
	}
}