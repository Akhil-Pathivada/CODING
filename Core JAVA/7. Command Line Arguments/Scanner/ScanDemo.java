import java.util.Scanner;
class ScanDemo
{
	public static void main(String args[])
	{
		Scanner ob=new Scanner(System.in);
		System.out.println("\nEnter some string data : ");
		String s=ob.nextLine();
		System.out.println("\nEnter some integer data : ");
		int i=ob.nextInt();
		System.out.println("\nEnter some integer data : ");
		int j=ob.nextInt();
		System.out.print("\n Enter some float data : ");
		float f=ob.nextFloat();
		System.out.print("\n Enter some double data : ");
		double d=ob.nextDouble();
		System.out.println("s : "+s);
		System.out.println("i : "+i);
		System.out.println("j : "+j);
		System.out.println("f : "+f);
		System.out.println("d : "+d);
	}
}