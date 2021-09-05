//A stream is a sequence of data. 
//In Java, a stream is composed of bytes.
class StreamDemo1
{
	public static void main(String args[])
	{
		System.out.println("Simple message"); //standard output stream
		System.err.println("Error message"); //standard error stream
		// getting input from console
		int i=System.in.read(); //returns Ascii code of first character
		System.out.println((char)i);
	}
}
/*
Simple message
Error message
*/