//The ByteArrayOutputStream holds a copy of data and forwards it to multiple streams
import java.io.*;
class ByteArrayOutputStreamExample
{
	public static void main(String args[]) throws Exception
	{
		FileOutputStream f1=new FileOutputStream("C:/Users/AKHIL/Desktop/Java/Programs/Files/ByteArrayOutputStream1.txt");
		FileOutputStream f2=new FileOutputStream("C:/Users/AKHIL/Desktop/Java/Programs/Files/ByteArrayOutputStream2.txt");
		ByteArrayOutputStream bout=new ByteArrayOutputStream();
		String s="Welcome to JAVA";
		byte b[]=s.getBytes();
		bout.write(b);
		bout.writeTo(f1);
		bout.writeTo(f2);
		bout.close();
	}
}