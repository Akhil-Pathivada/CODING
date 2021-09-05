//The replace() method replaces the given string from the specified beginIndex and endIndex.
class StringBuffer3
{  
	public static void main(String args[])
	{  
		StringBuffer sb=new StringBuffer("Hello");  
		sb.replace(1,3,"Java");  
		System.out.println(sb);//prints HJavalo  
	}  
}