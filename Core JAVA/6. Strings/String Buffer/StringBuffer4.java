//The delete() method of StringBuffer class deletes the string from the specified beginIndex to endIndex.
class StringBuffer4
{
	public static void main(String args[])
	{
		StringBuffer s1=new StringBuffer("Hello");
		s1.delete(1,3);
		System.out.println(s1);//prints Hlo  
	}
}