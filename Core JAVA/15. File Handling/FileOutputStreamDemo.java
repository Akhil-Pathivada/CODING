//If you have to write primitive values into a file, use FileOutputStream class.
// You can write byte-oriented as well as character-oriented data through FileOutputStream class. 
// for character-oriented data, it is better to use FileWriter class
// example to write a byte into a file....
import java.io.*;
class FileOutputStreamDemo
{
	public static void main(String args[])
	{
		try
		{
			FileOutputStream fout=new FileOutputStream("C:/Users/AKHIL/Desktop/Java/Programs/Files/FileOuput.txt");
			fout.write(66);
			fout.close();
			System.out.println("Success....");
		}
		catch(Exception e){System.out.println(e);}
	}
}
// character 'B' will be written into file 'FileOutput.txt'