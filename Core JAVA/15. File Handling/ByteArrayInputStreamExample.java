//it can be used to read byte array as input stream.....
import java.io.*;  
public class ByteArrayInputStreamExample 
{  
	public static void main(String[] args) throws IOException 
	{  
		byte[] buf = { 35, 36, 37, 38 };  
		// Create the new byte array input stream  
		ByteArrayInputStream byt = new ByteArrayInputStream(buf);  
		int k = 0;  
		while ((k = byt.read()) != -1) 
		{  
			//Conversion of a byte into character  
			char ch = (char) k;  
			System.out.println("ASCII value of Character is:" + k + "; Special character is: " + ch);  
		}  
	}  
}  
/*
ASCII value of Character is:35; Special character is: #
ASCII value of Character is:36; Special character is: $
ASCII value of Character is:37; Special character is: %
ASCII value of Character is:38; Special character is: &
*/