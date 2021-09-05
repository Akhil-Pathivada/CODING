//Java FileWriter class is used to write character-oriented data to a file.
// It is character-oriented class which is used for file handling in java.
//Unlike FileOutputStream class, you don't need to convert string into byte array because it provides method to write string directly.
import java.io.*;
class FileWriterExample
{
	public static void main(String args[]) throws Exception
	{
		FileWriter fw=new FileWriter("C:/Users/AKHIL/Desktop/Java/Programs/Files/FileWriter.txt");
		String s="Welcome to JAVA";
		fw.write(s); // fw.write("Welcome to JAVA");
		fw.close();
		System.out.println("Success......");
	}
}
//Success......