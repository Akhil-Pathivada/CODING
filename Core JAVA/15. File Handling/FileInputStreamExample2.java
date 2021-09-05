//example for reading all characters
import java.io.*;
class FileInputStreamExample2
{
	public static void main(String args[])
	{
		try
		{
			FileInputStream fin =new FileInputStream("C:/Users/AKHIL/Desktop/Java/Programs/Files/FileInput.txt");
			int i;
			while((i=fin.read())!= -1)
				System.out.print((char)i);
			fin.close();
		}
		catch(Exception e){System.out.println(e);};
	}
}
//Welcome to JAVA