//reading from 2 files and writing into other file
import java.io.*;
class SequenceInputStreamExample2
{
	public static void main(String args[]) throws Exception
	{
		FileInputStream f1=new FileInputStream("C:/Users/AKHIL/Desktop/Java/Programs/Files/FileWriter.txt");
		FileInputStream f2=new FileInputStream("C:/Users/AKHIL/Desktop/Java/Programs/Files/BufferedWriter.txt");
		SequenceInputStream s=new SequenceInputStream(f1,f2);
		FileOutputStream fout=new FileOutputStream("C:/Users/AKHIL/Desktop/Java/Programs/Files/SequenceInputStream.txt");      
		int i;
		 while((i=s.read())!=-1)
		{
			fout.write(i);
		}
		f1.close();
		f2.close();
		s.close();
	}
}