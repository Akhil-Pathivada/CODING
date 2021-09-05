/*
The ensureCapacity() method of StringBuffer class ensures that the given capacity is the minimum to the current capacity.
If it is greater than the current capacity, it increases the capacity by (oldcapacity*2)+2. For example if your current capacity is 16, it will be (16*2)+2=34. 
*/
class StringBuffer7
{
	public static void main(String args[])
	{
		StringBuffer s1=new StringBuffer();
		System.out.println(s1.capacity()); //16
		s1.append("Hello");
		System.out.println(s1.capacity());//16
		s1.append("JAVA is my favourite language");
		System.out.println(s1.capacity()); //34
		s1.ensureCapacity(10); //34
		System.out.println(s1.capacity());
		s1.ensureCapacity(50); //70
		System.out.println(s1.capacity());
	}
}
/*
16
16
34
34
70
*/