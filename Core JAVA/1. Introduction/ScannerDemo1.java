// Java program to read data of various types using Scanner class.
import java.util.Scanner;
public class ScannerDemo1
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\n Enter age :");
		int age=sc.nextInt();
		//System.out.println(" Enter name :");
		//String name=sc.nextLine();
		System.out.println(" Enter mobile no :");
		long mobileNo = sc.nextLong();
		System.out.println(" Enter CGPA :");
        double cgpa = sc.nextDouble();
		//System.out.println(" Name : "+name);
		System.out.println(" Age : "+age);
		System.out.println("Mobile : "+mobileNo);
		System.out.println("CGPA : "+cgpa);
	}
}
