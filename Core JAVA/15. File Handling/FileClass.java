import java.io.*;
class FileClass
{
	public static void main(String args[])
	{
		File f1=new File("C:/Users/AKHIL/Desktop/Java/Programs/Files/StreamDemo1.java");
		System.out.println("Name : "+f1.getName());
		System.out.println("Path : "+f1.getPath());
		System.out.println("Absolute path : "+f1.getAbsolutePath());
		System.out.println("Exists : "+f1.exists());
		System.out.println("Size : "+f1.length());
		System.out.println("Last Modified : "+f1.lastModified());
		System.out.println("is Absolute : "+f1.isAbsolute());
		System.out.println("is File : "+f1.isFile());
	}
}
/*
Path : C:\Users\AKHIL\Desktop\Java\Programs\Files\StreamDemo1.java
Absolute path : C:\Users\AKHIL\Desktop\Java\Programs\Files\StreamDemo1.java
Exists : true
Size : 452
Last Modified : 1542942230272
is Absolute : true
is File : true
*/