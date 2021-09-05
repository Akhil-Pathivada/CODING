//writting a string into a file....
import java.io.*;
import java.util.Scanner;
class FileOutputStreamDemo2
{
	public static void main(String args[])
	{
		try
		{
			FileOutputStream fout=new FileOutputStream("C:/Users/AKHIL/Desktop/Java/Programs/Files/FileOuput2.txt");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the string u want to write : ");
			String s=sc.nextLine();
			// converting into ByteArray
			byte b[]=s.getBytes();
			fout.write(b);
			fout.close();
			System.out.println("Success.....");
		}
		catch(Exception e){};
	}
}