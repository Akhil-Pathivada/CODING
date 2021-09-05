//Converting a  Wrapper object into Primitive datatype
class Wrapper_class2
{
	public static void main(String args[])
	{
		Integer ob=new Integer(100);
		int num=ob.intValue();//converting Integer to int   
		int num2=ob;//unboxing, now compiler will write ob.intValue() internally
		System.out.println(ob+" "+num1+" "+num2);
	}
}
/*
 Output : 
		100 100 100
		*/