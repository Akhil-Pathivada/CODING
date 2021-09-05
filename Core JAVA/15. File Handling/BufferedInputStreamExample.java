//Java BufferedInputStream class is used to read information from stream. It internally uses buffer mechanism to make the performance fast.
import java.io.*;
class BufferedInputStreamExample
{
	public static void main(String args[]) throws Exception
	{
		FileInputStream fin=new FileInputStream("C:/Users/AKHIL/Desktop/Java/Programs/Files/BufferedOutput.txt");
		BufferedInputStream bin=new BufferedInputStream(fin);
		int i;
		while((i=bin.read())!=-1)
		{
			System.out.print((char)i);
		}
		bin.close();
		fin.close();
	}
}
//Welcome to JAVA