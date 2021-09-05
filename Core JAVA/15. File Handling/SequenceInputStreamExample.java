//SequenceInputStream class is used to read data from multiple streams. 
//It reads data sequentially (one by one).
import java.io.*;
class SequenceInputStreamExample 
{
	public static void main(String args[]) throws Exception
	{
		FileInputStream f1=new FileInputStream("C:/Users/AKHIL/Desktop/Java/Programs/Files/FileWriter.txt");
		FileInputStream f2=new FileInputStream("C:/Users/AKHIL/Desktop/Java/Programs/Files/BufferedWriter.txt");
		SequenceInputStream s=new SequenceInputStream(f1,f2);
		int i;
		 while((i=s.read())!=-1)
		{
			System.out.print((char)i);
		}
		f1.close();
		f2.close();
		s.close();
	}
}
/*
Welcome to JAVAWelcome to JAVA
(/