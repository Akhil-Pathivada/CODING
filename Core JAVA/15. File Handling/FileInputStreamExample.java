//Java FileInputStream class obtains input bytes from a file.
//It is used for reading byte-oriented data (streams of raw bytes)
//You can also read character-stream data. But, for reading streams of characters, it is recommended to use FileReader class.
//example for reading a Single character....
import java.io.*;
class FileInputStreamExample
{
	public static void main(String args[])
	{
		try
		{
			FileInputStream fin=new FileInputStream("C:/Users/AKHIL/Desktop/Java/Programs/Files/FileInput.txt");
			int i=fin.read(); //reads first character
			System.out.println((char)i);
			fin.close();
		}
		catch(Exception e){};
	}
}
//W