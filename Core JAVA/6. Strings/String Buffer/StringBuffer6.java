//The capacity() method of StringBuffer class returns the current capacity of the buffer. 
class StringBuffer6
{
	public static void main(String args[])
	{
		StringBuffer s1=new StringBuffer();
		System.out.println("intial capacity : "+s1.capacity());
		s1.append("HELLO");
		System.out.println("String s1 : "+s1);
		System.out.println("length: "+s1.length());
		System.out.println("capacity: "+s1.capacity());
		s1.append("JAVA is my favourite language");
		System.out.println("length: "+s1.length());
		System.out.println("capacity: "+s1.capacity());
		System.out.println("-------------------------------");
		StringBuffer s2=new StringBuffer("HELLO");
		System.out.println("String s2 :"+s2);
		System.out.println("length: "+s2.length());
		System.out.println("capacity: "+s2.capacity()); // 5+16
		s2.append("JAVA is my favourite language");
		System.out.println("length: "+s2.length());
		System.out.println("capacity: "+s2.capacity());
	}
}
/*
intial capacity : 16
String s1 : HELLO
length: 5
capacity: 16
length: 34
capacity: 34
-------------------------------
String s2 :HELLO
length: 5
capacity: 21
length: 34
capacity: 44
*/