//Converting a primitive type to Wrapper object
class Wrapper_class1
{
	public static void main(String args[])
	{
		int num=100;
		Integer ob=Integer.valueOf(num);//converting int into Integer  
		Integer ob2=num;//autoboxing, now compiler will write Integer.valueOf(100) internally  
		System.out.println(" "+num+" "+ob+" "+ob2);
	}
}
/*
 Output : 
		100 100 100
		*/