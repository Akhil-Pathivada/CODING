//Java BufferedOutputStream class is used for buffering an output stream. 
//It internally uses buffer to store data. It adds more efficiency than to write data directly into a stream. So, it makes the performance fast.
// in this example., we are writing the textual information in the BufferedOutputStream object which is connected to the FileOutputStream object.
import java.io.*;
class BufferedOutputStreamExample
{
	public static void main(String args[]) throws Exception
	{
		FileOutputStream fout=new FileOutputStream("C:/Users/AKHIL/Desktop/Java/Programs/Files/BufferedOutput.txt");
		BufferedOutputStream bout=new BufferedOutputStream(fout);
		String s="Welcome to JAVA";
		byte b[]=s.getBytes();
		bout.write(b);
		// bout.flush();  //not needed
		bout.close();
		fout.close();
		System.out.println("Success.....");
	}
}
//flush() flushes the data of one stream and send it into another. 