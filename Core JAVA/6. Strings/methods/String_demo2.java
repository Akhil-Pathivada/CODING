// using Length,Equals,CharAt methods
class String_demo2
{
	public static void main(String args[])
	{
		String str1="first string";
		String str2="second string";
		String str3=str1;
		System.out.println(str1);
		System.out.println("length of str1 : "+str1.length());
		System.out.println(str2);
		System.out.println("length of str2 : "+str2.length());
		System.out.println(str3);
		System.out.println("length of str3 : "+str3.length());
		System.out.println("---------------------------------");
		if(str1.equals(str2)) 
			System.out.println("str1==str2");
		else
			System.out.println("str1!=str2");
		if(str1.equals(str3))
			System.out.println("str1==str3");
		else
			System.out.println("str1!=str3");
		System.out.println("---------------------------------");
		System.out.println("character at index 3 in str1 = "+str1.charAt(3));
		System.out.println("character at index 4 in str2 = "+str2.charAt(4));
		System.out.println("character at index 6 in str3 = "+str3.charAt(6));
		System.out.println("---------------------------------");
	}
}
/*

first string
length of str1 : 12
second string
length of str2 : 13
first string
length of str3 : 12
---------------------------------
str1!=str2
str1==str3
---------------------------------
character at index 3 in str1 = s
character at index 4 in str2 = n
character at index 6 in str3 = s
---------------------------------
*/