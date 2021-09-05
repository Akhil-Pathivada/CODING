//Java BufferedWriter class is used to provide buffering for Writer instances.
// It makes the performance fast. It inherits Writer class.
// The buffering characters are used for providing the efficient writing of single arrays, characters, and strings.
// example for writinf data into file
import java.io.*;
class BufferedWriterExample
{
	public static void main(String args[]) throws Exception
	{
		FileWriter fw=new FileWriter("C:/Users/AKHIL/Desktop/Java/Programs/Files/BufferedWriter.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write("Welcome to JAVA");
		bw.close();
		fw.close();
		System.out.println("Success.....");
	}
}
//Success.....